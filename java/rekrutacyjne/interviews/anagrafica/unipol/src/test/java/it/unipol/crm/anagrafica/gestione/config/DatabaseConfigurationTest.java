package it.unipol.crm.anagrafica.gestione.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.support.GenericWebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DatabaseConfigurationTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void shouldFindDataSourceBean() {
        GenericWebApplicationContext context = (GenericWebApplicationContext) this.context;
        String dataSourceBeanName = DatabaseConfiguration.PERSISTENCE_DATA_SOURCE_BEAN_NAME;
        final boolean b = context.containsBean(dataSourceBeanName);
        assertTrue(b);
    }
}
