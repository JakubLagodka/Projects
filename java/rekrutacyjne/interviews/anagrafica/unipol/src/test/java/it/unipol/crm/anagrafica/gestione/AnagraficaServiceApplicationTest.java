package it.unipol.crm.anagrafica.gestione;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
class AnagraficaServiceApplicationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void applicationContextShouldNotBeNull() {
        assertNotNull(context);
    }

    @Test
    void shouldRunApplication() {
        AnagraficaServiceApplication.main(new String[] {});
    }
}