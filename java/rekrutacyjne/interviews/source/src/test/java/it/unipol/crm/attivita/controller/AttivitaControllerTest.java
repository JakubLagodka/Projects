package it.unipol.crm.attivita.controller;

import it.unipol.crm.attivita.model.InsertAttivitaWithConfigResponse;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaException;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaValidationException;
import it.unipol.crm.attivita.persistence.model.Attivita;
import it.unipol.crm.attivita.persistence.model.NuovaAttivita;
import it.unipol.crm.attivita.service.AttivitaService;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.math.BigInteger;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AttivitaControllerTest {

    @Mock
    private AttivitaService service;

    @InjectMocks
    private AttivitaController fixture;

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
    public void shouldReturnOkAndAttivitaWhenFound(){
        //given
        val attivita = new Attivita();
        attivita.setId(1l);

        given(service.getAttivita(BigInteger.ONE)).willReturn(Optional.of(attivita));

        //when
        val actual = fixture.getAttivita(BigInteger.ONE, new Date(), "xUnipolRequestId", "xUnipolApplication");

        //then
        assertNotNull(actual);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals(attivita, actual.getBody());
    }

    @Test
    public void shouldReturnBadRequestWhenNullIdOnGet(){
        //given
        //when
        val actual = fixture.getAttivita(null, new Date(), "xUnipolRequestId", "xUnipolApplication");

        //then
        assertNotNull(actual);
        assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());
    }

    @Test
    public void shouldReturnNotFoundWhenNotFound(){
        //given
        given(service.getAttivita(BigInteger.valueOf(404))).willReturn(Optional.empty());

        //when
        val actual = fixture.getAttivita(BigInteger.valueOf(404), new Date(), "xUnipolRequestId", "xUnipolApplication");

        //then
        assertNotNull(actual);
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
    }

    @Test
    public void shouldAddAttivita() throws URISyntaxException, NuovaAttivitaValidationException, NuovaAttivitaException {
        //given
        val request = new NuovaAttivita();
        val created = new Attivita();
        created.setId(7l);

        List<Attivita> attivitaList = new ArrayList<>();
        attivitaList.add(created);
        Jwt jwt = mock(Jwt.class);
        given(jwt.getTokenValue()).willReturn("token");

        given(service.addAttivita(request,AUTHORIZATION.getName(), "xUnipolApplication", "token")).willReturn(attivitaList);
        //when
        val actual = fixture.addAttivita(AUTHORIZATION, request, new Date(), "xUnipolRequestId", "xUnipolApplication", jwt);

        //then
        assertNotNull(actual);
        assertNotNull(actual.getBody());
        assertNotNull(actual.getBody().getAttivitaList());
        assertEquals(HttpStatus.CREATED, actual.getStatusCode());
        assertEquals(created, actual.getBody().getAttivitaList().get(0));
    }

    @Test
    public void shouldAddAttivitaWithConfiguratore() throws URISyntaxException, NuovaAttivitaValidationException, NuovaAttivitaException {
        //given
        val request = new NuovaAttivita();
        val created = new Attivita();
        created.setId(7L);
        val created1 = new Attivita();
        created1.setId(8L);
        List<Attivita> attivitaList = Arrays.asList(created, created1);
        val response = new InsertAttivitaWithConfigResponse();
        response.setAttivitaList(attivitaList);
        Jwt jwt = mock(Jwt.class);
        given(jwt.getTokenValue()).willReturn("token");

        given(service.addAttivita(request,AUTHORIZATION.getName(), "xUnipolApplication", "token")).willReturn(attivitaList);
        //when
        val actual = fixture.addAttivita(AUTHORIZATION, request, new Date(), "xUnipolRequestId", "xUnipolApplication", jwt);

        //then
        assertNotNull(actual);
        assertEquals(HttpStatus.CREATED, actual.getStatusCode());
        assertEquals(response, actual.getBody());
    }

    @Test
    public void shouldUpdateAttivita(){
        //given
        val request = new Attivita();
        request.setId(10l);

        val updated = new Attivita();
        updated.setId(10l);
        updated.setDataUltimoAggiornamento(LocalDateTime.now());

        given(service.updateAttivita(ArgumentMatchers.any(Attivita.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).willReturn(updated);

        //when
        val actual = fixture.updateAttivita(AUTHORIZATION, request, new Date(), "xUnipolRequestId", "xUnipolApplication");

        //then
        assertNotNull(actual);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals(updated, actual.getBody());
    }

    @Test
    public void shouldReturnBadRequestWhenNullIdOnUpdate(){
        //given
        val request = new Attivita();

        //when
        val actual = fixture.updateAttivita(AUTHORIZATION, request, new Date(), "xUnipolRequestId", "xUnipolApplication");

        //then
        assertNotNull(actual);
        assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());
    }

    @Test
    public void shouldReturnNotFoundWhenNotFoundForUpdate(){
        //given
        val request = new Attivita();
        request.setId(500l);

        given(service.updateAttivita(ArgumentMatchers.any(Attivita.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).willThrow(new NoSuchElementException());

        //when
        val actual = fixture.updateAttivita(AUTHORIZATION, request, new Date(), "xUnipolRequestId", "xUnipolApplication");

        //then
        assertNotNull(actual);
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
    }

    @Test
    public void shouldDeleteAttivita() {
        //given
        BigInteger attivitaId = BigInteger.valueOf(1000);

        //when
        fixture.deleteAttivita(attivitaId, new Date(), "xUnipolRequestId", "xUnipolApplication");

        //then
        verify(service, times(1)).deleteAttivita(attivitaId);
    }

    @Test
    public void shouldReturnBadRequestWhenNullIdOnDelete(){
        //when
        val actual = fixture.deleteAttivita(null, new Date(), "xUnipolRequestId", "xUnipolApplication");

        //then
        assertNotNull(actual);
        assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());

    }

}