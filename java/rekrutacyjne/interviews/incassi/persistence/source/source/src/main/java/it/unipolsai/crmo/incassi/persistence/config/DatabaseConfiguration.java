package it.unipolsai.crmo.incassi.persistence.config;

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
        basePackages = "it.unipolsai.crmo.incassi.persistence",
        entityManagerFactoryRef = "contabilitaEntityManager",
        transactionManagerRef = "contabilitaTransactionManager"
)
@ComponentScan(basePackages = "it.unipolsai.crmo.incassi.persistence")
public class DatabaseConfiguration {

    public static final String PERSISTENCE_DATA_SOURCE_BEAN_NAME = "contabilitaPersistenceDataSource";

    @ConfigurationProperties(prefix = "contabilita.datasource")
    @Bean(name = PERSISTENCE_DATA_SOURCE_BEAN_NAME)
    public DataSource persistenceDataSource (
            @Value("${CONTABILITA_PERSISTENCE_DATASOURCE_URL}") String url,
            @Value("${CONTABILITA_PERSISTENCE_DATASOURCE_DRIVER_CLASS_NAME}") String driverClassName,
            @Value("${CONTABILITA_PERSISTENCE_DATASOURCE_USERNAME}") String username,
            @Value("${CONTABILITA_PERSISTENCE_DATASOURCE_PASSWORD}") String password
    ) {
        return DataSourceBuilder
                .create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }
    @Bean("contabilitaEntityManager")
    public LocalContainerEntityManagerFactoryBean persistenceEntityManager(
            @Autowired @Qualifier(PERSISTENCE_DATA_SOURCE_BEAN_NAME) DataSource contabilitaPersistenceDataSource,
            @Autowired Environment env
    ) {
        var em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(contabilitaPersistenceDataSource);
        em.setPackagesToScan("it.unipolsai.crmo.incassi.persistence.entity");
        var vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("HIBERNATE_HBM2DDL_AUTO", env.getProperty("HIBERNATE_HBM2DDL_AUTO"));
        properties.put("HIBERNATE_DIALECT", env.getProperty("HIBERNATE_DIALECT"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    public PlatformTransactionManager contabilitaTransactionManager (
            @Autowired @Qualifier("contabilitaEntityManager") LocalContainerEntityManagerFactoryBean contabilitaEntityManager
    ) {
        var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(contabilitaEntityManager.getObject());
        return transactionManager;
    }
}