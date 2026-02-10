package it.unipol.crm.attivita.batch.config;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        basePackages = "it.unipol.crm.attivita.batch.model",
        entityManagerFactoryRef = "inputEntityManager",
        transactionManagerRef = "inputTransactionManager"
)
public class DbConfiguration {


    private static final String HIBERNATE_HBM_2_DDL_AUTO = "HIBERNATE_HBM2DDL_AUTO";

    private static final String HIBERNATE_DIALECT = "HIBERNATE_DIALECT";

    @Autowired
    private Environment env;

    @Value("${INTERNAL_BATCH_DATASOURCE_URL}")
    String baseDataSourceJDBCUrl;

    @Value("${INTERNAL_BATCH_DATASOURCE_USERNAME}")
    String baseDataSourceUsername;

    @Value("${INTERNAL_BATCH_DATASOURCE_PASSWORD}")
    String baseDataSourcePassword;

    @Value("${INTERNAL_BATCH_DATASOURCE_DRIVERCLASSNAME}")
    String baseDataSourceDriverClassName;

    /**
     * Primary datasource will be delivered by attivita-persistence dependency library
     * In order to make it possible, attivita.persistence.datasource.* properties have to be filled in application.properties file
     */
    @Bean
    BatchConfigurer configurer(@Qualifier("batchDataSource") DataSource batchDataSource) {
        return new DefaultBatchConfigurer(batchDataSource);
    }

    /**
     * batch datasource - for Spring Batch internal purposes. The dedicated datasource is created
     * by attivita-persistence dependency library, based on attivita.persistence.datasource.* properties
     * which have to be defined in application.properties file of this project
     */
    @Bean(name = "batchDataSource")
    @Primary
    public DataSource batchDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(baseDataSourceDriverClassName);
        dataSource.setUrl(baseDataSourceJDBCUrl);
        dataSource.setUsername(baseDataSourceUsername);
        dataSource.setPassword(baseDataSourcePassword);

        return dataSource;
    }

    @Bean("batchEntityManager")
    public LocalContainerEntityManagerFactoryBean batchEntityManager(
            @Autowired @Qualifier("batchDataSource") DataSource batchDataSource
    ) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(batchDataSource);
        em.setPackagesToScan("it.unipol.crm.attivita.persistence.entity");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put(HIBERNATE_HBM_2_DDL_AUTO, env.getProperty(HIBERNATE_HBM_2_DDL_AUTO));
        properties.put(HIBERNATE_DIALECT, env.getProperty(HIBERNATE_DIALECT));
        em.setJpaPropertyMap(properties);
        return em;
    }


    @Bean("batchTransactionManager")
    @Primary
    public PlatformTransactionManager batchTransactionManager(
            @Autowired @Qualifier("batchEntityManager") LocalContainerEntityManagerFactoryBean batchEntityManager
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(batchEntityManager.getObject());
        return transactionManager;
    }

    /**
     * datasource for reader
     */
    @ConfigurationProperties(prefix = "input.datasource")
    @Bean(name = "inputDataSource")
    public @Qualifier("inputDataSource")
    DataSource inputDataSource(
            @Value("${STGDATASOURCE_DRIVERCLASSNAME}") String driverClassName,
            @Value("${STGDATASOURCE_URL}") String url,
            @Value("${STGDATASOURCE_USERNAME}") String username,
            @Value("${STGDATASOURCE_PASSWORD}") String password) {

        return DataSourceBuilder
                .create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

    @Bean("inputEntityManager")
    public LocalContainerEntityManagerFactoryBean inputEntityManager(
            @Autowired @Qualifier("inputDataSource") DataSource inputDataSource
    ) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(inputDataSource);
        em.setPackagesToScan("it.unipol.crm.attivita.batch.model");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put(HIBERNATE_HBM_2_DDL_AUTO, env.getProperty(HIBERNATE_HBM_2_DDL_AUTO));
        properties.put(HIBERNATE_DIALECT, env.getProperty(HIBERNATE_DIALECT));
        em.setJpaPropertyMap(properties);
        return em;
    }


    @Bean("inputTransactionManager")
    public PlatformTransactionManager inputTransactionManager(
            @Autowired @Qualifier("inputEntityManager") LocalContainerEntityManagerFactoryBean inputEntityManager
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(inputEntityManager.getObject());
        return transactionManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("inputDataSource") DataSource inputDataSource) {
        return new JdbcTemplate(inputDataSource);
    }
}
