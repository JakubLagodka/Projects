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
public class UpdateAnagraficaRequestMapperTest {
    @Autowired
    private UpdateAnagraficaRequestMapper updateAnagraficaRequestMapper;

    private UpdateAnagraficaRequest prepareInput() {
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
        input.getDatiAnagrafici().setTipoNdg(BigInteger.TEN);
        input.getAnagRel().setIdAnagRel(BigInteger.TEN);
        input.setIdSoggetto(BigInteger.TEN);
        return input;
    }

    @Test
    void shouldconvertUpdateAnagraficaRequestToUplCrmAnagraficaAgenzia() {

        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmAnagraficaAgenzia expected = new UplCrmAnagraficaAgenzia();
        expected.setIdSoggetto(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnagraficaAgenzia(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnagraficaAgenzia(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldconvertUpdateAnagraficaRequestToUplCrmAnagrafichePf() {

        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmAnagrafichePf expected = new UplCrmAnagrafichePf();
        expected.setIdSoggetto(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnagrafichePf(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnagrafichePf(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }
    @Test
    void shouldconvertUpdateAnagraficaRequestToUplCrmAnagrafiche(){
        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmAnagrafiche expected = new UplCrmAnagrafiche();
     
        expected.setTipondg(BigInteger.TEN);
        expected.setIdSoggetto(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnagrafiche(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnagrafiche(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }
    @Test
     void shouldconvertUpdateAnagraficaRequestToUplCrmAnagrafichePg(){
        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmAnagrafichePg expected = new UplCrmAnagrafichePg();
        expected.setIdSoggetto(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnagrafichePg(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnagrafichePg(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }
    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmAnomaleAnagrafiche(){
        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmAnomalieAnagrafiche expected = new UplCrmAnomalieAnagrafiche();
        expected.setIdSoggetto(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnomalieAnagrafiche(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnomalieAnagrafiche(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmAnagRel(){
        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmAnagRel expected = new UplCrmAnagRel();
        expected.setIdAnagRel(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnagRel(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmAnagRel(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }
    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmDatiSocioeconomici(){
        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmDatiSocioeconomici expected = new UplCrmDatiSocioeconomici();
        expected.setIdSoggetto(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmDatiSocioeconomici(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmDatiSocioeconomici(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmDatiSocioeconomiciPf(){
        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmDatiSocioeconomiciPf expected = new UplCrmDatiSocioeconomiciPf();
        expected.setIdSoggetto(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmDatiSocioeconomiciPf(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmDatiSocioeconomiciPf(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmDatiSocioeconomiciPfErrori(){
        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmDatiSocioeconomiciPfErrori expected = new UplCrmDatiSocioeconomiciPfErrori();
        expected.setIdSoggetto(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmDatiSocioeconomiciPfErrori(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmDatiSocioeconomiciPfErrori(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmDocumenti(){
        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmDocumenti expected = new UplCrmDocumenti();
        expected.setIdSoggetto(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmDocumenti(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmDocumenti(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmIndirizzi(){
        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmIndirizzi expected = new UplCrmIndirizzi();
     
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmIndirizzi(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmIndirizzi(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmRecapiti(){
        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmRecapiti expected = new UplCrmRecapiti();
        expected.setIdSoggetto(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmRecapiti(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmRecapiti(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmAnagraficaIdentita(){
        // given
       UpdateAnagraficaRequest input = prepareInput();

        UplCrmAnagraficaIdentita expected = new UplCrmAnagraficaIdentita();
        expected.setIdSoggetto(BigInteger.TEN);
        // when
        val given = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmIdentita(input);
        val givenNull = updateAnagraficaRequestMapper.  convertUpdateAnagraficaRequestToUplCrmIdentita(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }
}

