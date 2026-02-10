package it.unipol.crm.sinistro.persistence.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(
        basePackages = "it.unipol.crm.sinistro.persistence.entity",
        entityManagerFactoryRef = "sinistroEntityManager",
        transactionManagerRef = "sinistroTransactionManager"
)
@ComponentScan(basePackages = "it.unipol.crm.sinistro.persistence")
public class DatabaseConfiguration {


    public static final String PERSISTENCE_DATA_SOURCE_BEAN_NAME = "sinistroPersistenceDataSource";

    @ConfigurationProperties(prefix = "sinistro.datasource")
    @Bean(name = PERSISTENCE_DATA_SOURCE_BEAN_NAME)
    public DataSource sinistroPersistenceDataSource (
            @Value("${SINISTRO_PERSISTENCE_DATASOURCE_URL}") String url,
            @Value("${SINISTRO_PERSISTENCE_DATASOURCE_DRIVER_CLASS_NAME}") String driverClassName,
            @Value("${SINISTRO_PERSISTENCE_DATASOURCE_USERNAME}") String username,
            @Value("${SINISTRO_PERSISTENCE_DATASOURCE_PASSWORD}") String password
    ) {
        return DataSourceBuilder
                .create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }
    @Bean("sinistroEntityManager")
    public LocalContainerEntityManagerFactoryBean sinistroEntityManager(
            @Autowired @Qualifier(PERSISTENCE_DATA_SOURCE_BEAN_NAME) DataSource sinistroPersistenceDataSource,
            @Autowired Environment env
    ) {
        var em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(sinistroPersistenceDataSource);
        em.setPackagesToScan("it.unipol.crm.sinistro.persistence.entity");
        var vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("HIBERNATE_HBM2DDL_AUTO", env.getProperty("HIBERNATE_HBM2DDL_AUTO"));
        properties.put("HIBERNATE_DIALECT", env.getProperty("HIBERNATE_DIALECT"));
        em.setJpaPropertyMap(properties);
        return em;
    }


    @Bean
    public PlatformTransactionManager sinistroTransactionManager (
            @Autowired @Qualifier("sinistroEntityManager") LocalContainerEntityManagerFactoryBean sinistroEntityManager
    ) {
        var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(sinistroEntityManager.getObject());
        return transactionManager;
    }
}