package it.unipol.crm.sinistro.config;

import it.unipol.crm.sinistro.exception.WrongInputObjectException;
import it.unipol.crm.sinistro.model.ErroreRisp;
import org.hibernate.exception.JDBCConnectionException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomExceptionHandlerTest {

    @Autowired
    private CustomExceptionHandler customExceptionHandler;

    @Test
    void shouldReturnErroreRispWhenWrongInputObjectException() {

        // given
        var exception = new WrongInputObjectException("test", "test");

        // when
        ResponseEntity<ErroreRisp> given = customExceptionHandler.handleWrongInputObjectException(exception);

        // then
        assertNotNull(given);
        assertEquals(HttpStatus.BAD_REQUEST, given.getStatusCode());
        assertNotNull(given.getBody());
        assertEquals("test", given.getBody().getMessaggioErrore());
    }

    @Test
    void shouldReturnErroreRispWhenResponseStatusException() {

        // given
        var exception = new ResponseStatusException(HttpStatus.NOT_FOUND, "test");

        // when
        ResponseEntity<ErroreRisp> given = customExceptionHandler.handleResponseStatusException(exception);

        // then
        assertNotNull(given);
        assertEquals(HttpStatus.NOT_FOUND, given.getStatusCode());
        assertNotNull(given.getBody());
        assertEquals("test", given.getBody().getMessaggioErrore());
    }

    @Test
    void shouldReturnErroreRispWhenIllegalArgumentException() {

        // given
        var exception = new IllegalArgumentException("test");

        // when
        ResponseEntity<ErroreRisp> given = customExceptionHandler.handleIllegalArgumentException(exception);

        // then
        assertNotNull(given);
        assertEquals(HttpStatus.BAD_REQUEST, given.getStatusCode());
        assertNotNull(given.getBody());
        assertEquals("test", given.getBody().getMessaggioErrore());
    }

    @Test
    void shouldReturnErroreRispWhenConnectionException() {

        // given
        var exception = new JDBCConnectionException("test", new SQLException());

        // when
        ResponseEntity<ErroreRisp> given = customExceptionHandler.handleConnectionException(exception);

        // then
        assertNotNull(given);
        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, given.getStatusCode());
        assertNotNull(given.getBody());
        assertEquals("test", given.getBody().getMessaggioErrore());
    }

    @Test
    void shouldChangeErrorAttributes() {

        // given
        final DefaultErrorAttributes errorAttributes = new CustomErrorAttributes();
        final MockHttpServletRequest request = new MockHttpServletRequest();
        final WebRequest webRequest = new ServletWebRequest(request);

        // when
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(webRequest, false);

        // then
        assertFalse(attributes.containsKey("message"));
        assertTrue(attributes.containsKey("messaggioErrore"));
    }
}