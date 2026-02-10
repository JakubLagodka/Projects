package it.unipol.crm.anagrafica.gestione.service;

import it.unipol.crm.anagrafica.gestione.config.mapper.AnagraficaResponseMapper;
import it.unipol.crm.anagrafica.gestione.config.mapper.CreaAnagraficaRequestMapper;
import it.unipol.crm.anagrafica.gestione.config.mapper.UpdateAnagraficaRequestMapper;
import it.unipol.crm.anagrafica.gestione.entity.code.*;
import it.unipol.crm.anagrafica.gestione.model.AnagraficaResponse;
import it.unipol.crm.anagrafica.gestione.model.UplCrmAnagraficaContainer;
import it.unipol.crm.anagrafica.gestione.model.definitions.*;
import it.unipol.crm.anagrafica.gestione.util.HeaderParameters;
import it.unipol.crm.anagrafica.gestione.util.UserUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AnagraficaServiceTest {
    @InjectMocks
    private AnagraficaService anagraficaService;
    @Mock
    private AnagraficaResponseMapper mapper;
    @Mock
    private CreaAnagraficaRequestMapper creaAnagraficaRequestMapper;
    @Mock
    private UpdateAnagraficaRequestMapper updateAnagraficaRequestMapper;
    @Mock
    private AnagraficaPersistenceServiceModifingData anagraficaPersistenceService;
    @Mock
    private UplCrmAnagraficaContainer uplCrmAnagraficaContainer;
    @Mock
    private UserUtil userUtil;

    HeaderParameters populateHeaders() {
        HeaderParameters headers = new HeaderParameters();
        headers.setApplicationId("test");
        headers.setRequestId("test");
        return headers;
    }

    @Test
    public void shouldInsertAnagrafica() {

        // given
        AnagraficaResponse response = new AnagraficaResponse();

        Agenzia agenzia = new Agenzia();

        response.setIdSoggetto(null);
        response.setAgenzia(agenzia);
        response.setPrivacyProspect(new PrivacyProspect());

        CreaAnagraficaRequest request = getCreaAnagraficaRequest();
        var expected = new AnagraficaResponse();
        expected.setAgenzia(agenzia);

        BDDMockito.given(mapper.convertCreaAnagraficaRequestToAnagraficaResponse(any(CreaAnagraficaRequest.class))).willReturn(response);

        // when
        final AnagraficaResponse givenResponse = anagraficaService.insertAnagrafica(anyString(),request, populateHeaders());

        // then
        assertNotNull(givenResponse);
        assertEquals(expected, givenResponse);

    }
    @Test
    public void shouldUpdateAnagrafica() {

        // given

        UpdateAnagraficaRequest updateAnagraficaRequest = new UpdateAnagraficaRequest();
        AnagraficaResponse response = new AnagraficaResponse();

        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        updateAnagraficaRequest.setIdSoggetto(BigInteger.ONE);
        updateAnagraficaRequest.setDatiAnagrafici(new DatiAnagrafici());
        updateAnagraficaRequest.setDocumenti(new Documenti());
        updateAnagraficaRequest.getDocumenti().setIdDocumento(BigInteger.ONE);
        updateAnagraficaRequest.setIndirizzi(new Indirizzi());
        updateAnagraficaRequest.getIndirizzi().setIdIndirizzo(BigInteger.ONE);
        updateAnagraficaRequest.setAnagRel(new AnagRel());
        updateAnagraficaRequest.getAnagRel().setIdAnagRel(BigInteger.ONE);
        updateAnagraficaRequest.setRecapiti(new Recapiti());
        updateAnagraficaRequest.getRecapiti().setIdRecapito(BigInteger.ONE);
        updateAnagraficaRequest.setAgenzia(new Agenzia());
        updateAnagraficaRequest.getAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        updateAnagraficaRequest.setIdentita(new Identita());
        updateAnagraficaRequest.getIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        updateAnagraficaRequest.setPersonaFisica(new PersonaFisica());
        updateAnagraficaRequest.setPersonaGiuridica(new PersonaGiuridica());
        updateAnagraficaRequest.setAnomalieAnagrafiche(new AnomalieAnagrafiche());
        updateAnagraficaRequest.getAnomalieAnagrafiche().setIdAnomalia(BigInteger.ONE);
        updateAnagraficaRequest.setDatiSocioEconomici(new DatiSocioEconomici());
        updateAnagraficaRequest.getDatiSocioEconomici().setIdDatiSocioEconomici(BigInteger.ONE);
        updateAnagraficaRequest.setDatiSocioEconomiciPersoneFisiche(new DatiSocioEconomiciPersoneFisiche());
        updateAnagraficaRequest.getDatiSocioEconomiciPersoneFisiche().setIdDatiSocioEconomiciPersoneFisiche(BigInteger.ONE);
        updateAnagraficaRequest.setDatiSocioEconomiciPersoneFisicheErrori(new DatiSocioEconomiciPersoneFisicheErrori());
        updateAnagraficaRequest.getDatiSocioEconomiciPersoneFisicheErrori().setIdDatiSocioEconomiciPersoneFisicheErrori(BigInteger.ONE);
        updateAnagraficaRequest.setPrivacyProspect(new PrivacyProspect());
        updateAnagraficaRequest.getPrivacyProspect().setIdPrivacyProspect(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));
        updateAnagraficaRequest.setIdSoggetto(new BigInteger("1"));
        container.setUplCrmAnagraficaAgenzia(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmAnagraficaAgenzia(response));
        var expected = new AnagraficaResponse();

        BDDMockito.when(mapper.convertUpdateAnagraficaRequestToAnagraficaResponse(any(UpdateAnagraficaRequest.class))).thenReturn(response);
        // when
        final AnagraficaResponse givenResponse = anagraficaService.updateAnagrafica(anyString(),new BigInteger("1"), updateAnagraficaRequest, populateHeaders());

        // then
        assertNotNull(givenResponse);
        assertEquals(expected, givenResponse);

    }
    private static CreaAnagraficaRequest getCreaAnagraficaRequest() {
        CreaAnagraficaRequest request = new CreaAnagraficaRequest();
        request.setDatiAnagrafici(new DatiAnagrafici());
        request.setDatiSocioEconomiciPersoneFisiche(new DatiSocioEconomiciPersoneFisiche());
        request.setDatiSocioEconomici(new DatiSocioEconomici());
        request.setDatiSocioEconomiciPersoneFisicheErrori(new DatiSocioEconomiciPersoneFisicheErrori());
        request.setIndirizzi(new Indirizzi());
        request.setDocumenti(new Documenti());
        request.setAgenzia(new Agenzia());
        request.setPersonaFisica(new PersonaFisica());
        request.setRecapiti(new Recapiti());
        request.setAnagRel(new AnagRel());
        request.setAnomalieAnagrafiche(new AnomalieAnagrafiche());
        request.setPersonaGiuridica(new PersonaGiuridica());
        request.setPrivacyProspect(new PrivacyProspect());
        return request;
    }
}
