package it.unipol.crm.attivita.service;

import it.unipol.crm.attivita.enums.OperationType;
import it.unipol.crm.attivita.model.McEventi;
import it.unipol.crm.attivita.model.UpdateAttivitaEventoRequest;
import it.unipol.crm.attivita.model.UpdateAttivitaEventoResponse;
import it.unipol.crm.attivita.persistence.constants.UplCrmAttivitaConstants;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaException;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaValidationException;
import it.unipol.crm.attivita.persistence.model.Attivita;
import it.unipol.crm.attivita.persistence.model.NuovaAttivita;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.oauth2.jwt.Jwt;

import javax.naming.OperationNotSupportedException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class AttivitaEventoServiceTest {

    @Mock
    private AttivitaService attivitaService;

    @Mock
    private McEventiService mcEventiService;

    @InjectMocks
    private AttivitaEventoService attivitaEventoService;

    McEventi mcEventiNewValues;
    Attivita attivitaNewValues;
    NuovaAttivita nuovaAttivita;

    @Before
    public void init() {
        Mockito.reset(attivitaService, mcEventiService);
    }

    public AttivitaEventoServiceTest() {

        mcEventiNewValues = new McEventi();
        mcEventiNewValues.setMcEventiId(BigInteger.valueOf(723952095513575335l));
        mcEventiNewValues.setEntityName("CAMPAIGNASSOCIATtest");
        mcEventiNewValues.setNota("CONTATTATO-test");
        mcEventiNewValues.setCanaleTpCd(BigInteger.ONE);
        mcEventiNewValues.setLastUpdateUser("junit");

        attivitaNewValues = new Attivita();
        attivitaNewValues.setId(564456486841891635l);
        attivitaNewValues.setDominio(1004L);
        attivitaNewValues.setCodice(1020L);
        attivitaNewValues.setContestoEntita("test");
        attivitaNewValues.setCodiceFiscaleCliente("test");
        attivitaNewValues.setContestoIdentificativo("123");

        nuovaAttivita = new NuovaAttivita();
        nuovaAttivita.setCreatoDaTipo(UplCrmAttivitaConstants.CREATA_DA_UTENTE);
        nuovaAttivita.setCreatoDaUtente("Test");
        nuovaAttivita.setCreatoDaNominativo("JUnit");
        nuovaAttivita.setCompagnia("1");
        nuovaAttivita.setAgenziaMadre("00003");
        nuovaAttivita.setAgenziaFiglia("00003");
        nuovaAttivita.setTipoAttivitaId(5l);
        nuovaAttivita.setCodiceFiscaleCliente("codfisc");
        nuovaAttivita.setPriorita("5");
        final LocalDateTime now = LocalDateTime.now();
        nuovaAttivita.setDataAvvio(now);
        nuovaAttivita.setDataScadenza(now);
        nuovaAttivita.setEscalation("F");
    }

    @Test
    public void shouldInsertAttivitaAndInsertEvento() throws OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setAttivitaOperationType(OperationType.INSERT);
        request.setEventiOperationType(OperationType.INSERT);
        request.setAttivita(null);
        request.setNuovaAttivita(nuovaAttivita);
        request.setMcEventi(mcEventiNewValues);

        UpdateAttivitaEventoResponse expectedResponse = new UpdateAttivitaEventoResponse();
        expectedResponse.setAttivitaOperationType(OperationType.INSERT);
        expectedResponse.setEventiOperationType(OperationType.INSERT);
        expectedResponse.setAttivita(attivitaNewValues);
        expectedResponse.setMcEventi(mcEventiNewValues);

        List<Attivita> attivitaList = new ArrayList<>();
        attivitaList.add(attivitaNewValues);

        Jwt jwt = mock(Jwt.class);
        given(jwt.getTokenValue()).willReturn("token");

        BDDMockito.given(attivitaService.addAttivita(any(NuovaAttivita.class), anyString(), anyString(), eq("token"))).willReturn(attivitaList);
        BDDMockito.given(mcEventiService.insertMcEventi(any(McEventi.class))).willReturn(mcEventiNewValues);

        // when
        final UpdateAttivitaEventoResponse response = attivitaEventoService.processAttivitaEvento(request, "test", "test", jwt);

        // then
        Assert.assertEquals(expectedResponse, response);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenAttivitaOperationTypeIsNull() throws OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setAttivitaOperationType(null);

        Jwt jwt = mock(Jwt.class);

        // when
        final UpdateAttivitaEventoResponse response = attivitaEventoService.processAttivitaEvento(request, "test", "test", jwt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenEventiOperationTypeIsNull() throws OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setEventiOperationType(null);

        Jwt jwt = mock(Jwt.class);

        // when
        final UpdateAttivitaEventoResponse response = attivitaEventoService.processAttivitaEvento(request, "test", "test", jwt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenEventiOperationTypeIsNotNullAndMcEventiIsNull() throws OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setEventiOperationType(OperationType.INSERT);
        request.setMcEventi(null);

        Jwt jwt = mock(Jwt.class);

        // when
        final UpdateAttivitaEventoResponse response = attivitaEventoService.processAttivitaEvento(request, "test", "test", jwt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenAttivitaOperationTypeIsInsertAndNuovaAttivitaIsNull() throws OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setAttivitaOperationType(OperationType.INSERT);
        request.setNuovaAttivita(null);

        Jwt jwt = mock(Jwt.class);

        // when
        final UpdateAttivitaEventoResponse response = attivitaEventoService.processAttivitaEvento(request, "test", "test", jwt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenAttivitaOperationTypeIsUpdateAndAttivitaIsNull() throws OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setAttivitaOperationType(OperationType.UPDATE);
        request.setAttivita(null);

        Jwt jwt = mock(Jwt.class);

        // when
        final UpdateAttivitaEventoResponse response = attivitaEventoService.processAttivitaEvento(request, "test", "test", jwt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenAttivitaOperationTypeIsDeleteAndAttivitaIsNull() throws OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setAttivitaOperationType(OperationType.DELETE);
        request.setAttivita(null);

        Jwt jwt = mock(Jwt.class);

        // when
        final UpdateAttivitaEventoResponse response = attivitaEventoService.processAttivitaEvento(request, "test", "test", jwt);
    }

    @Test
    public void shouldUpdateAttivitaAndInsertEvento() throws OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setAttivitaOperationType(OperationType.UPDATE);
        request.setEventiOperationType(OperationType.INSERT);
        request.setAttivita(attivitaNewValues);
        request.setNuovaAttivita(null);
        request.setMcEventi(mcEventiNewValues);

        UpdateAttivitaEventoResponse expectedResponse = new UpdateAttivitaEventoResponse();
        expectedResponse.setAttivitaOperationType(OperationType.UPDATE);
        expectedResponse.setEventiOperationType(OperationType.INSERT);
        expectedResponse.setAttivita(attivitaNewValues);
        expectedResponse.setMcEventi(mcEventiNewValues);

        BDDMockito.given(attivitaService.updateAttivita(any(Attivita.class), anyString(), anyString())).willReturn(attivitaNewValues);
        BDDMockito.given(mcEventiService.insertMcEventi(any(McEventi.class))).willReturn(mcEventiNewValues);

        Jwt jwt = mock(Jwt.class);

        // when
        final UpdateAttivitaEventoResponse response = attivitaEventoService.processAttivitaEvento(request, "test", "test", jwt);

        // then
        Assert.assertEquals(expectedResponse, response);
    }

    @Test
    public void shouldDeleteAttivitaAndInsertEvento() throws OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setAttivitaOperationType(OperationType.DELETE);
        request.setEventiOperationType(OperationType.INSERT);
        request.setAttivita(attivitaNewValues);
        request.setNuovaAttivita(null);
        request.setMcEventi(mcEventiNewValues);

        UpdateAttivitaEventoResponse expectedResponse = new UpdateAttivitaEventoResponse();
        expectedResponse.setAttivitaOperationType(OperationType.DELETE);
        expectedResponse.setEventiOperationType(OperationType.INSERT);
        expectedResponse.setAttivita(null);
        expectedResponse.setMcEventi(mcEventiNewValues);

        BDDMockito.given(attivitaService.deleteAttivita(any(BigInteger.class))).willReturn(attivitaNewValues);
        BDDMockito.given(mcEventiService.insertMcEventi(any(McEventi.class))).willReturn(mcEventiNewValues);

        Jwt jwt = mock(Jwt.class);

        // when
        final UpdateAttivitaEventoResponse response = attivitaEventoService.processAttivitaEvento(request, "test", "test", jwt);

        // then
        Assert.assertEquals(expectedResponse, response);
    }

    @Test
    public void shouldInsertAttivitaAndDeleteEvento() throws OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setAttivitaOperationType(OperationType.INSERT);
        request.setEventiOperationType(OperationType.DELETE);
        request.setAttivita(null);
        request.setNuovaAttivita(nuovaAttivita);
        request.setMcEventi(mcEventiNewValues);

        UpdateAttivitaEventoResponse expectedResponse = new UpdateAttivitaEventoResponse();
        expectedResponse.setAttivitaOperationType(OperationType.INSERT);
        expectedResponse.setEventiOperationType(OperationType.DELETE);
        expectedResponse.setAttivita(attivitaNewValues);
        expectedResponse.setMcEventi(null);

        List<Attivita> attivitaList = new ArrayList<>();
        attivitaList.add(attivitaNewValues);

        Jwt jwt = mock(Jwt.class);
        given(jwt.getTokenValue()).willReturn("token");

        BDDMockito.given(attivitaService.addAttivita(any(NuovaAttivita.class), anyString(), anyString(), eq("token"))).willReturn(attivitaList);
        BDDMockito.willDoNothing().given(mcEventiService).deleteMcEventi(any(McEventi.class));

        // when
        final UpdateAttivitaEventoResponse response = attivitaEventoService.processAttivitaEvento(request, "test", "test", jwt);

        // then
        Assert.assertEquals(expectedResponse, response);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldInsertAttivitaAndThrowExceptionBecauseUpdateEventoIsNotSupported() throws OperationNotSupportedException, NuovaAttivitaValidationException, NuovaAttivitaException {

        // given
        UpdateAttivitaEventoRequest request = new UpdateAttivitaEventoRequest();
        request.setAttivitaOperationType(OperationType.INSERT);
        request.setEventiOperationType(OperationType.UPDATE);
        request.setAttivita(null);
        request.setNuovaAttivita(nuovaAttivita);
        request.setMcEventi(mcEventiNewValues);

        List<Attivita> attivitaList = new ArrayList<>();
        attivitaList.add(attivitaNewValues);

        Jwt jwt = mock(Jwt.class);
        given(jwt.getTokenValue()).willReturn("token");

        BDDMockito.given(attivitaService.addAttivita(any(NuovaAttivita.class), anyString(), anyString(), eq("token"))).willReturn(attivitaList);

        // when
        final UpdateAttivitaEventoResponse response = attivitaEventoService.processAttivitaEvento(request, "test", "test", jwt);
    }
}
