package it.unipol.crm.sinistro.controller;

import it.unipol.crm.sinistro.ModelPopulator;
import it.unipol.crm.sinistro.model.sinistro.Sinistro;
import it.unipol.crm.sinistro.model.sinistro.SinistroPaginatoRisp;
import it.unipol.crm.sinistro.model.sinistro.SinistroRisp;
import it.unipol.crm.sinistro.service.SinistroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
class SinistroControllerTest {

    @Mock
    private SinistroService service;

    @InjectMocks
    private SinistroController controller;

    @BeforeEach
    public void init(){
        Mockito.reset(service);
    }

    private final Authentication AUTHORIZATION = new Authentication() {
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
            return "uid=JUnit";
        }
    };

    @Test
    void shouldReturnSinistroRisp() {

        // given
        final SinistroRisp expected = new SinistroRisp();

        BDDMockito.given(service.getSinistro(any(BigInteger.class))).willReturn(expected);

        // when
        final ResponseEntity<SinistroRisp> given = controller.getSinistro(AUTHORIZATION, BigInteger.ONE, "xUnipolRequestId", "xUnipolApplication");

        // then
        assertNotNull(given);
        assertEquals(HttpStatus.OK, given.getStatusCode());
        assertEquals(expected, given.getBody());
    }

    @Test
    void shouldReturnSinistroPaginatoRisp() {

        // given
        final SinistroPaginatoRisp expected = new SinistroPaginatoRisp();

        BDDMockito.given(service.getSinistri(any(BigInteger.class), any(Integer.class), any(Integer.class),
                any(LocalDate.class), any(LocalDate.class), any(String.class), any())).willReturn(expected);

        // when
        final ResponseEntity<SinistroPaginatoRisp> given = controller.getSinistri(AUTHORIZATION, "xUnipolRequestId", "xUnipolApplication",
                BigInteger.ONE, 0, 20, LocalDate.MIN, LocalDate.MAX, "120180890000419014", BigInteger.ONE);

        // then
        assertNotNull(given);
        assertEquals(HttpStatus.OK, given.getStatusCode());
        assertEquals(expected, given.getBody());
    }

    @Test
    void shouldAddSinistro() {

        // given
        Sinistro request = ModelPopulator.prepareSinistro();

        SinistroRisp response = ModelPopulator.prepareSinistroRisp();
        response.setId(BigInteger.ONE);

        final ResponseEntity<SinistroRisp> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).body(response);

        BDDMockito.given(service.addSinistro(request, "request-id", "uid=JUnit", "test")).willReturn(response);

        // when
        final ResponseEntity<SinistroRisp> givenResponse = controller.addSinistro(AUTHORIZATION, request, "request-id", "test");

        // then
        assertNotNull(givenResponse);
        assertEquals(HttpStatus.CREATED, givenResponse.getStatusCode());
        assertEquals(expectedResponse, givenResponse);
    }
}