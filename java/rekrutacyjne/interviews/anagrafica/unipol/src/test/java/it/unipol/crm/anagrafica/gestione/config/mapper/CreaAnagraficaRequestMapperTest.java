package it.unipol.crm.anagrafica.gestione.config.mapper;

import it.unipol.crm.anagrafica.gestione.entity.code.*;
import it.unipol.crm.anagrafica.gestione.model.definitions.*;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CreaAnagraficaRequestMapperTest {
    @Autowired
    private CreaAnagraficaRequestMapper creaAnagraficaRequestMapper;
    private CreaAnagraficaRequest prepareInput() {
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
        return input;
    }

    @Test
    void shouldConvertCreaAnagraficaRequestToUplCrmAnagraficaAgenzia() {

        // given
        CreaAnagraficaRequest input = prepareInput();
        input.getAgenzia().setIdAnagraficaAgenzia(BigInteger.TEN);

        UplCrmAnagraficaAgenzia expected = new UplCrmAnagraficaAgenzia();
        expected.setIdAnagraficaAgenzia(BigInteger.TEN);
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagraficaAgenzia(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagraficaAgenzia(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertCreaAnagraficaRequestToUplCrmAnagrafichePf() {

        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmAnagrafichePf expected = new UplCrmAnagrafichePf();
        
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagrafichePf(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagrafichePf(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }
    @Test
    void shouldConvertCreaAnagraficaRequestToUplCrmAnagrafiche(){
        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmAnagrafiche expected = new UplCrmAnagrafiche();
        
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagrafiche(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagrafiche(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }
    @Test
     void shouldConvertCreaAnagraficaRequestToUplCrmAnagrafichePg(){
        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmAnagrafichePg expected = new UplCrmAnagrafichePg();
        
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagrafichePg(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagrafichePg(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }
    @Test
    void  shouldConvertCreaAnagraficaRequestToUplCrmAnomaleAnagrafiche(){
        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmAnomalieAnagrafiche expected = new UplCrmAnomalieAnagrafiche();
        
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnomalieAnagrafiche(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnomalieAnagrafiche(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldConvertCreaAnagraficaRequestToUplCrmAnagRel(){
        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmAnagRel expected = new UplCrmAnagRel();
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagRel(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagRel(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }
    @Test
    void  shouldConvertCreaAnagraficaRequestToUplCrmDatiSocioeconomici(){
        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmDatiSocioeconomici expected = new UplCrmDatiSocioeconomici();
        
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDatiSocioeconomici(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDatiSocioeconomici(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldConvertCreaAnagraficaRequestToUplCrmDatiSocioeconomiciPf(){
        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmDatiSocioeconomiciPf expected = new UplCrmDatiSocioeconomiciPf();
        
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDatiSocioeconomiciPf(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDatiSocioeconomiciPf(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldConvertCreaAnagraficaRequestToUplCrmDatiSocioeconomiciPfErrori(){
        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmDatiSocioeconomiciPfErrori expected = new UplCrmDatiSocioeconomiciPfErrori();
        
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDatiSocioeconomiciPfErrori(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDatiSocioeconomiciPfErrori(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldConvertCreaAnagraficaRequestToUplCrmDocumenti(){
        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmDocumenti expected = new UplCrmDocumenti();
        
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDocumenti(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDocumenti(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldConvertCreaAnagraficaRequestToUplCrmIndirizzi(){
        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmIndirizzi expected = new UplCrmIndirizzi();
        
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmIndirizzi(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmIndirizzi(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldConvertCreaAnagraficaRequestToUplCrmRecapiti(){
        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmRecapiti expected = new UplCrmRecapiti();
        
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmRecapiti(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmRecapiti(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldConvertCreaAnagraficaRequestToUplCrmAnagraficaIdentita(){
        // given
        CreaAnagraficaRequest input = prepareInput();

        UplCrmAnagraficaIdentita expected = new UplCrmAnagraficaIdentita();
        
        // when
        val given = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmIdentita(input);
        val givenNull = creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmIdentita(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }
}

