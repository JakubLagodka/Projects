package it.unipol.crm.anagrafica.gestione.config;

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
        basePackages = "it.unipol.crm.anagrafica.gestione",
        entityManagerFactoryRef = "anagraficaEntityManager",
        transactionManagerRef = "anagraficaTransactionManager"
)
@ComponentScan(basePackages = "it.unipol.crm.anagrafica.gestione")
public class DatabaseConfiguration {

    public static final String PERSISTENCE_DATA_SOURCE_BEAN_NAME = "anagraficaPersistenceDataSource";

    @ConfigurationProperties(prefix = "anagrafica.datasource")
    @Bean(name = PERSISTENCE_DATA_SOURCE_BEAN_NAME)
    public DataSource anagraficaPersistenceDataSource (
            @Value("${ANAGRAFICA_PERSISTENCE_DATASOURCE_URL}") String url,
            @Value("${ANAGRAFICA_PERSISTENCE_DATASOURCE_DRIVER_CLASS_NAME}") String driverClassName,
            @Value("${ANAGRAFICA_PERSISTENCE_DATASOURCE_USERNAME}") String username,
            @Value("${ANAGRAFICA_PERSISTENCE_DATASOURCE_PASSWORD}") String password
    ) {
        return DataSourceBuilder
                .create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }
    @Bean("anagraficaEntityManager")
    public LocalContainerEntityManagerFactoryBean persistenceEntityManager(
            @Autowired @Qualifier(PERSISTENCE_DATA_SOURCE_BEAN_NAME) DataSource anagraficaPersistenceDataSource,
            @Autowired Environment env
    ) {
        var em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(anagraficaPersistenceDataSource);
        em.setPackagesToScan("it.unipol.crm.anagrafica.gestione.entity");
        var vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("HIBERNATE_HBM2DDL_AUTO", env.getProperty("HIBERNATE_HBM2DDL_AUTO"));
        properties.put("HIBERNATE_DIALECT", env.getProperty("HIBERNATE_DIALECT"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    public PlatformTransactionManager anagraficaTransactionManager (
            @Autowired @Qualifier("anagraficaEntityManager") LocalContainerEntityManagerFactoryBean anagraficaEntityManager
    ) {
        var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(anagraficaEntityManager.getObject());
        return transactionManager;
    }
}