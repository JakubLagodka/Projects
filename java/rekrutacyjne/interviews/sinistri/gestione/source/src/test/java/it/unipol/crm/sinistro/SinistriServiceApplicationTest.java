package it.unipol.crm.sinistro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
class SinistriServiceApplicationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void applicationContextShouldNotBeNull() {
        assertNotNull(context);
    }
}