package it.unipol.crm.anagrafica.gestione.controller;

import it.unipol.crm.anagrafica.gestione.model.AnagraficaResponse;
import it.unipol.crm.anagrafica.gestione.service.AnagraficaService;
import it.unipol.crm.anagrafica.gestione.util.HeaderParameters;
import it.unipol.crm.anagrafica.gestione.model.definitions.CreaAnagraficaRequest;
import it.unipol.crm.anagrafica.gestione.model.definitions.DatiAnagrafici;
import it.unipol.crm.anagrafica.gestione.model.definitions.UpdateAnagraficaRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AnagraficaControllerTest {
    @Mock
    AnagraficaService anagraficaService;
    @Mock
    HeaderParameters headerParameters;
    @InjectMocks
    AnagraficaController anagraficaController;
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
    public void shouldNotInsertAnagraficaWhenInputIsEmpty(){

        // given
        BDDMockito.given(anagraficaService.insertAnagrafica(anyString(),any(CreaAnagraficaRequest.class), any(HeaderParameters.class))).willReturn(new AnagraficaResponse());
        BDDMockito.given(headerParameters.checkIfHeaderParametersAreProper(any(String.class), any(String.class) )).willReturn(true);
        // then
        assertThrows(IllegalArgumentException.class,()->anagraficaController.insertAnagrafica( AUTHORIZATION,"test", "test",  null));
    }
    @Test
    public void shouldNotUpdateAnagraficaWhenInputIsEmpty(){

        // given
        BDDMockito.given(anagraficaService.updateAnagrafica(anyString(),any(BigInteger.class), any(UpdateAnagraficaRequest.class), any(HeaderParameters.class))).willReturn(new AnagraficaResponse());
        BDDMockito.given(headerParameters.checkIfHeaderParametersAreProper(any(String.class), any(String.class) )).willReturn(true);
        // then
        assertThrows(IllegalArgumentException.class,()->anagraficaController.updateAnagrafica( AUTHORIZATION,"test", "test",new BigInteger("1"),  null));
    }

    @Test
    void shouldInsertAnagrafica()  {
        CreaAnagraficaRequest creaAnagraficaRequest = new CreaAnagraficaRequest();
        creaAnagraficaRequest.setDatiAnagrafici(new DatiAnagrafici());
        // given
        BDDMockito.given(anagraficaService.insertAnagrafica(anyString(),any(CreaAnagraficaRequest.class), any(HeaderParameters.class))).willReturn(new AnagraficaResponse());
        BDDMockito.given(headerParameters.checkIfHeaderParametersAreProper(any(String.class), any(String.class) )).willReturn(true);
        final ResponseEntity<AnagraficaResponse> expectedResponse = ResponseEntity.ok().body(new AnagraficaResponse());
        // when
        final ResponseEntity<AnagraficaResponse> givenResponse = anagraficaController.insertAnagrafica( AUTHORIZATION,"test", "test", creaAnagraficaRequest);

        // then
        assertNotNull(givenResponse);
        assertEquals(HttpStatus.OK, givenResponse.getStatusCode());
        assertEquals(expectedResponse, givenResponse);
    }
    @Test
    void shouldUpdateAnagrafica()  {
        UpdateAnagraficaRequest updateAnagraficaRequest = new UpdateAnagraficaRequest();
        updateAnagraficaRequest.setDatiAnagrafici(new DatiAnagrafici());
        // given
        BDDMockito.given(anagraficaService.updateAnagrafica(anyString(),any(BigInteger.class), any(UpdateAnagraficaRequest.class), any(HeaderParameters.class))).willReturn(new AnagraficaResponse());
        BDDMockito.given(headerParameters.checkIfHeaderParametersAreProper(any(String.class), any(String.class) )).willReturn(true);
        final ResponseEntity<AnagraficaResponse> expectedResponse = ResponseEntity.ok().body(new AnagraficaResponse());
        // when
        final ResponseEntity<AnagraficaResponse> givenResponse = anagraficaController.updateAnagrafica( AUTHORIZATION,"test", "test", new BigInteger("1"), updateAnagraficaRequest);

        // then
        assertNotNull(givenResponse);
        assertEquals(HttpStatus.OK, givenResponse.getStatusCode());
        assertEquals(expectedResponse, givenResponse);
    }
}
