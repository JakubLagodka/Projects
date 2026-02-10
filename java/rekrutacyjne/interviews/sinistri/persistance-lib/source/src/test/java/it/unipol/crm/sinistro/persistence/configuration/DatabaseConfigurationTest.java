package it.unipol.crm.sinistro.persistence.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = DatabaseConfiguration.class)
class DatabaseConfigurationTest {
    @Autowired
    private ApplicationContext context;

    @Test
    void shouldFindDataSourceBean() {
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) this.context;
        String dataSourceBeanName = DatabaseConfiguration.PERSISTENCE_DATA_SOURCE_BEAN_NAME;
        final boolean b = context.containsBean(dataSourceBeanName);
        assertTrue(b);
    }
}
