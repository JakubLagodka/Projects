package it.unipol.crm.attivita.batch.config;

import it.unipol.crm.attivita.persistence.configuration.DatabaseConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DbConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void checkIfattivitaPersistenceDataSourceBeanExists() {
        checkBean(DatabaseConfiguration.PERSISTENCE_DATA_SOURCE_BEAN_NAME);
    }

    @Test
    public void checkIfattivitaPersistenceDataSourceBeanExistsAndIsNotPrimary() {
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) this.context;
        String dataSourceBeanName = DatabaseConfiguration.PERSISTENCE_DATA_SOURCE_BEAN_NAME;
        BeanDefinition beanDefinition = context.getBeanDefinition(dataSourceBeanName);
        boolean isPrimary = beanDefinition.isPrimary();
        Assert.assertFalse(isPrimary);
    }

    @Test
    public void checkIfattivitaTransactionManagerBeanExists() {
        checkBean("attivitaTransactionManager");
    }

    private void checkBean(String attivitaTransactionManager) {
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) this.context;
        boolean b = context.containsBean(attivitaTransactionManager);
        Assert.assertTrue(b);
    }

    @Test
    public void checkIfattivitaTransactionManagerBeanExistsAndIsNotPrimary() {
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) this.context;
        String dataSourceBeanName = "attivitaTransactionManager";
        BeanDefinition beanDefinition = context.getBeanDefinition(dataSourceBeanName);
        boolean isPrimary = beanDefinition.isPrimary();
        Assert.assertFalse(isPrimary);
    }

    @Test
    public void checkIfBatchDataSourceBeanExists() {
        checkBean("batchDataSource");
    }

    @Test
    public void checkIfBatchDataSourceBeanExistsAndIsPrimary() {
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) this.context;
        String dataSourceBeanName = "batchDataSource";
        BeanDefinition beanDefinition = context.getBeanDefinition(dataSourceBeanName);
        boolean isPrimary = beanDefinition.isPrimary();
        Assert.assertTrue(isPrimary);
    }

    @Test
    public void checkIfBatchTransactionManagerBeanExists() {
        checkBean("batchTransactionManager");
    }

    @Test
    public void checkIfBatchTransactionManagerBeanExistsAndIsPrimary() {
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) this.context;
        String dataSourceBeanName = "batchTransactionManager";
        BeanDefinition beanDefinition = context.getBeanDefinition(dataSourceBeanName);
        boolean isPrimary = beanDefinition.isPrimary();
        Assert.assertTrue(isPrimary);
    }
}
