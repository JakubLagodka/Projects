package it.unipol.crm.anagrafica.gestione.config.mapper;

import it.unipol.crm.anagrafica.gestione.entity.code.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class AnagraficaEntitiesUpdateMapperTest {
    @Autowired
    private AnagraficaEntitiesUpdateMapper anagraficaEntitiesUpdateMapper;
    @Test
    void shouldconvertUpdateAnagraficaRequestToUplCrmAnagraficaAgenzia() {

        // given
        UplCrmAnagraficaAgenzia input = new UplCrmAnagraficaAgenzia();

        UplCrmAnagraficaAgenzia expected = new UplCrmAnagraficaAgenzia();
        // when
        UplCrmAnagraficaAgenzia given = new UplCrmAnagraficaAgenzia();
        anagraficaEntitiesUpdateMapper.uplCrmAnagraficaAgenziaUpdate(given,input);
        UplCrmAnagraficaAgenzia givenSource = new UplCrmAnagraficaAgenzia();
        anagraficaEntitiesUpdateMapper.uplCrmAnagraficaAgenziaUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }
    @Test
    void shouldconvertUpdateAnagraficaRequestToUplCrmAnagrafichePf() {

        // given
        UplCrmAnagrafichePf input = new UplCrmAnagrafichePf();

        UplCrmAnagrafichePf expected = new UplCrmAnagrafichePf();
        // when
        UplCrmAnagrafichePf given = new UplCrmAnagrafichePf();
        anagraficaEntitiesUpdateMapper.uplCrmAnagrafichePfUpdate(given,input);
        UplCrmAnagrafichePf givenSource = new UplCrmAnagrafichePf();
        anagraficaEntitiesUpdateMapper.uplCrmAnagrafichePfUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }
    @Test
    void shouldconvertUpdateAnagraficaRequestToUplCrmAnagrafiche(){
        // given
        UplCrmAnagrafiche input = new UplCrmAnagrafiche();

        UplCrmAnagrafiche expected = new UplCrmAnagrafiche();
        // when
        UplCrmAnagrafiche given = new UplCrmAnagrafiche();
        anagraficaEntitiesUpdateMapper.uplCrmAnagraficheUpdate(given,input);
        UplCrmAnagrafiche givenSource = new UplCrmAnagrafiche();
        anagraficaEntitiesUpdateMapper.uplCrmAnagraficheUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }
    @Test
     void shouldconvertUpdateAnagraficaRequestToUplCrmAnagrafichePg(){
        // given
        UplCrmAnagrafichePg input = new UplCrmAnagrafichePg();

        UplCrmAnagrafichePg expected = new UplCrmAnagrafichePg();
        // when
        UplCrmAnagrafichePg given = new UplCrmAnagrafichePg();
        anagraficaEntitiesUpdateMapper.uplCrmAnagrafichePgUpdate(given,input);
        UplCrmAnagrafichePg givenSource = new UplCrmAnagrafichePg();
        anagraficaEntitiesUpdateMapper.uplCrmAnagrafichePgUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }
    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmAnomaleAnagrafiche(){
        // given
        UplCrmAnomalieAnagrafiche input = new UplCrmAnomalieAnagrafiche();

        UplCrmAnomalieAnagrafiche expected = new UplCrmAnomalieAnagrafiche();
        // when
        UplCrmAnomalieAnagrafiche given = new UplCrmAnomalieAnagrafiche();
        anagraficaEntitiesUpdateMapper.uplCrmAnomalieAnagraficheUpdate(given,input);
        UplCrmAnomalieAnagrafiche givenSource = new UplCrmAnomalieAnagrafiche();
        anagraficaEntitiesUpdateMapper.uplCrmAnomalieAnagraficheUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmAnagRel(){
        // given
        UplCrmAnagRel input = new UplCrmAnagRel();

        UplCrmAnagRel expected = new UplCrmAnagRel();

        // when
        UplCrmAnagRel given = new UplCrmAnagRel();
        anagraficaEntitiesUpdateMapper.uplCrmAnagRelUpdate(given,input);
        UplCrmAnagRel givenSource = new UplCrmAnagRel();
        anagraficaEntitiesUpdateMapper.uplCrmAnagRelUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }
    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmDatiSocioeconomici(){
        // given
        UplCrmDatiSocioeconomici input = new UplCrmDatiSocioeconomici();

        UplCrmDatiSocioeconomici expected = new UplCrmDatiSocioeconomici();
        // when
        UplCrmDatiSocioeconomici given = new UplCrmDatiSocioeconomici();
        anagraficaEntitiesUpdateMapper.uplCrmDatiSocioeconomiciUpdate(given,input);
        UplCrmDatiSocioeconomici givenSource = new UplCrmDatiSocioeconomici();
        anagraficaEntitiesUpdateMapper.uplCrmDatiSocioeconomiciUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmDatiSocioeconomiciPf(){
        // given
        UplCrmDatiSocioeconomiciPf input = new UplCrmDatiSocioeconomiciPf();

        UplCrmDatiSocioeconomiciPf expected = new UplCrmDatiSocioeconomiciPf();
        // when
        UplCrmDatiSocioeconomiciPf given = new UplCrmDatiSocioeconomiciPf();
        anagraficaEntitiesUpdateMapper.uplCrmDatiSocioeconomiciPfUpdate(given,input);
        UplCrmDatiSocioeconomiciPf givenSource = new UplCrmDatiSocioeconomiciPf();
        anagraficaEntitiesUpdateMapper.uplCrmDatiSocioeconomiciPfUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmDatiSocioeconomiciPfErrori(){
        // given
        UplCrmDatiSocioeconomiciPfErrori input = new UplCrmDatiSocioeconomiciPfErrori();

        UplCrmDatiSocioeconomiciPfErrori expected = new UplCrmDatiSocioeconomiciPfErrori();
        // when
        UplCrmDatiSocioeconomiciPfErrori given = new UplCrmDatiSocioeconomiciPfErrori();
        anagraficaEntitiesUpdateMapper.uplCrmDatiSocioeconomiciPfErroriUpdate(given,input);
        UplCrmDatiSocioeconomiciPfErrori givenSource = new UplCrmDatiSocioeconomiciPfErrori();
        anagraficaEntitiesUpdateMapper.uplCrmDatiSocioeconomiciPfErroriUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmDocumenti(){
        // given
        UplCrmDocumenti input = new UplCrmDocumenti();

        UplCrmDocumenti expected = new UplCrmDocumenti();
        // when
        UplCrmDocumenti given = new UplCrmDocumenti();
        anagraficaEntitiesUpdateMapper.uplCrmDocumentiUpdate(given,input);
        UplCrmDocumenti givenSource = new UplCrmDocumenti();
        anagraficaEntitiesUpdateMapper.uplCrmDocumentiUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmIndirizzi(){
        // given
        UplCrmIndirizzi input = new UplCrmIndirizzi();

        UplCrmIndirizzi expected = new UplCrmIndirizzi();
        // when
        UplCrmIndirizzi given = new UplCrmIndirizzi();
        anagraficaEntitiesUpdateMapper.uplCrmIndirizziUpdate(given,input);
        UplCrmIndirizzi givenSource = new UplCrmIndirizzi();
        anagraficaEntitiesUpdateMapper.uplCrmIndirizziUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmRecapiti(){
        // given
        UplCrmRecapiti input = new UplCrmRecapiti();

        UplCrmRecapiti expected = new UplCrmRecapiti();
        // when
        UplCrmRecapiti given = new UplCrmRecapiti();
        anagraficaEntitiesUpdateMapper.uplCrmRecapitiUpdate(given,input);
        UplCrmRecapiti givenSource = new UplCrmRecapiti();
        anagraficaEntitiesUpdateMapper.uplCrmRecapitiUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }

    @Test
    void  shouldconvertUpdateAnagraficaRequestToUplCrmAnagraficaIdentita(){
        // given
        UplCrmAnagraficaIdentita input = new UplCrmAnagraficaIdentita();

        UplCrmAnagraficaIdentita expected = new UplCrmAnagraficaIdentita();
        // when
        UplCrmAnagraficaIdentita given = new UplCrmAnagraficaIdentita();
        anagraficaEntitiesUpdateMapper.uplCrmAnagraficaIdentitaUpdate(given,input);
        UplCrmAnagraficaIdentita givenSource = new UplCrmAnagraficaIdentita();
        anagraficaEntitiesUpdateMapper.uplCrmAnagraficaIdentitaUpdate(givenSource,null);

        // then
        assertEquals(expected, given);
        assertEquals(input,givenSource);
    }
}

