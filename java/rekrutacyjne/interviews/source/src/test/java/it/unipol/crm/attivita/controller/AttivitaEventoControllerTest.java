package it.unipol.crm.attivita.controller;

import it.unipol.crm.attivita.persistence.model.Attivita;
import it.unipol.crm.attivita.model.McEventi;
import it.unipol.crm.attivita.model.UpdateAttivitaEventoRequest;
import it.unipol.crm.attivita.model.UpdateAttivitaEventoResponse;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaException;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaValidationException;
import it.unipol.crm.attivita.service.AttivitaEventoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import javax.naming.OperationNotSupportedException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Date;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class AttivitaEventoControllerTest {

    @Mock
    private AttivitaEventoService service;

    @InjectMocks
    private AttivitaEventoController controller;

    @Before
    public void init(){
        Mockito.reset(service);
    }

    private Authentication AUTHORIZATION = new Authentication() {
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public Object getCredentials() {
            return null;
        }

        @Override
        public Object getDetails() {
            return null;
        }

        @Override
        public Object getPrincipal() {
            return null;
        }

        @Override
        public boolean isAuthenticated() {
            return false;
        }

        @Override
        public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

        }

        @Override
        public String getName() {
            return "JUnit";
        }
    };

    @Test
    public void shouldReturnBadRequestForNullBodyObject() throws URISyntaxException {

        // given
        UpdateAttivitaEventoRequest request = null;
        Jwt jwt = mock(Jwt.class);

        // when
        final ResponseEntity<UpdateAttivitaEventoResponse> response = controller.updateAttivitaEvento(AUTHORIZATION, request, new Date(), "xUnipolRequestId", "xUnipolApplication", jwt);

        // then
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void shouldProcessAttivitaEvento() throws URISyntaxException, OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setAttivita(new Attivita());
        request.setMcEventi(new McEventi());

        UpdateAttivitaEventoResponse expectedResponse = new UpdateAttivitaEventoResponse();
        expectedResponse.setAttivita(new Attivita());
        expectedResponse.setMcEventi(new McEventi());
        Jwt jwt = mock(Jwt.class);

        BDDMockito.given(service.processAttivitaEvento(ArgumentMatchers.any(UpdateAttivitaEventoRequest.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), any())).willReturn(expectedResponse);

        // when
        final ResponseEntity<UpdateAttivitaEventoResponse> response = controller.updateAttivitaEvento(AUTHORIZATION, request, new Date(), "xUnipolRequestId", "xUnipolApplication", jwt);

        // then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    public void shouldReturnNotFoundWhenServiceThrowNoSuchElementException() throws URISyntaxException, OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setAttivita(new Attivita());
        request.setMcEventi(new McEventi());
        Jwt jwt = mock(Jwt.class);

        BDDMockito.given(service.processAttivitaEvento(ArgumentMatchers.any(UpdateAttivitaEventoRequest.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), any())).willThrow(NoSuchElementException.class);

        // when
        final ResponseEntity<UpdateAttivitaEventoResponse> response = controller.updateAttivitaEvento(AUTHORIZATION, request, new Date(), "xUnipolRequestId", "xUnipolApplication", jwt);

        // then
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
