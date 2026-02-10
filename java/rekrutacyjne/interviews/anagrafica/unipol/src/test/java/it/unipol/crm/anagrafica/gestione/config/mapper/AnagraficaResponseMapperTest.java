package it.unipol.crm.anagrafica.gestione.config.mapper;

import it.unipol.crm.anagrafica.gestione.model.AnagraficaResponse;
import it.unipol.crm.anagrafica.gestione.model.definitions.*;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class AnagraficaResponseMapperTest {
    @Autowired
    AnagraficaResponseMapper anagraficaMapper;

    @Test
    void shouldConvertCreaAnagraficaRequestToAnagraficaResponse() {

        // given
        CreaAnagraficaRequest input = new CreaAnagraficaRequest();
        input.setAgenzia(new Agenzia());
        input.setAnagRel(new AnagRel());
        input.setDocumenti(new Documenti());
        input.setIdentita(new Identita());
        input.setAnomalieAnagrafiche(new AnomalieAnagrafiche());
        input.setRecapiti(new Recapiti());
        input.setDatiAnagrafici(new DatiAnagrafici());
        input.setDatiSocioEconomici(new DatiSocioEconomici());
        input.setDatiSocioEconomiciPersoneFisiche(new DatiSocioEconomiciPersoneFisiche());
        input.setDatiSocioEconomiciPersoneFisicheErrori(new DatiSocioEconomiciPersoneFisicheErrori());
        input.setIndirizzi(new Indirizzi());
        input.setPersonaFisica(new PersonaFisica());
        input.setPersonaGiuridica(new PersonaGiuridica());
        input.setPrivacyProspect(new PrivacyProspect());

        AnagraficaResponse expected = new AnagraficaResponse();
        expected.setAgenzia(new Agenzia());
        expected.setAnagRel(new AnagRel());
        expected.setDocumenti(new Documenti());
        expected.setIdentita(new Identita());
        expected.setAnomalieAnagrafiche(new AnomalieAnagrafiche());
        expected.setRecapiti(new Recapiti());
        expected.setDatiAnagrafici(new DatiAnagrafici());
        expected.setDatiSocioEconomici(new DatiSocioEconomici());
        expected.setDatiSocioEconomiciPersoneFisiche(new DatiSocioEconomiciPersoneFisiche());
        expected.setDatiSocioEconomiciPersoneFisicheErrori(new DatiSocioEconomiciPersoneFisicheErrori());
        expected.setIndirizzi(new Indirizzi());
        expected.setPersonaFisica(new PersonaFisica());
        expected.setPersonaGiuridica(new PersonaGiuridica());
        expected.setPrivacyProspect(new PrivacyProspect());
        // when
        val given = anagraficaMapper.convertCreaAnagraficaRequestToAnagraficaResponse(input);
        val givenNull = anagraficaMapper.convertCreaAnagraficaRequestToAnagraficaResponse(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertUpdateAnagraficaRequestToAnagraficaResponse() {

        // given
        UpdateAnagraficaRequest input = new UpdateAnagraficaRequest();
        input.setAgenzia(new Agenzia());
        input.setAnagRel(new AnagRel());
        input.setDocumenti(new Documenti());
        input.setIdentita(new Identita());
        input.setAnomalieAnagrafiche(new AnomalieAnagrafiche());
        input.setRecapiti(new Recapiti());
        input.setDatiAnagrafici(new DatiAnagrafici());
        input.setDatiSocioEconomici(new DatiSocioEconomici());
        input.setDatiSocioEconomiciPersoneFisiche(new DatiSocioEconomiciPersoneFisiche());
        input.setDatiSocioEconomiciPersoneFisicheErrori(new DatiSocioEconomiciPersoneFisicheErrori());
        input.setIndirizzi(new Indirizzi());
        input.setPersonaFisica(new PersonaFisica());
        input.setPersonaGiuridica(new PersonaGiuridica());
        input.setPrivacyProspect(new PrivacyProspect());

        AnagraficaResponse expected = new AnagraficaResponse();
        expected.setAgenzia(new Agenzia());
        expected.setAnagRel(new AnagRel());
        expected.setDocumenti(new Documenti());
        expected.setIdentita(new Identita());
        expected.setAnomalieAnagrafiche(new AnomalieAnagrafiche());
        expected.setRecapiti(new Recapiti());
        expected.setDatiAnagrafici(new DatiAnagrafici());
        expected.setDatiSocioEconomici(new DatiSocioEconomici());
        expected.setDatiSocioEconomiciPersoneFisiche(new DatiSocioEconomiciPersoneFisiche());
        expected.setDatiSocioEconomiciPersoneFisicheErrori(new DatiSocioEconomiciPersoneFisicheErrori());
        expected.setIndirizzi(new Indirizzi());
        expected.setPersonaFisica(new PersonaFisica());
        expected.setPersonaGiuridica(new PersonaGiuridica());
        expected.setPrivacyProspect(new PrivacyProspect());
        expected.setIdSoggetto(null);

        // when
        val given = anagraficaMapper.convertUpdateAnagraficaRequestToAnagraficaResponse(input);
        val givenNull = anagraficaMapper.convertUpdateAnagraficaRequestToAnagraficaResponse(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }
}
