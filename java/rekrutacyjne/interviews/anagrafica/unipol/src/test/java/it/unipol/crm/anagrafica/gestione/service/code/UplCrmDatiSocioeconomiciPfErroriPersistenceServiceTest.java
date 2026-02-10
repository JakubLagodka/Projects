package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmDatiSocioeconomiciPfErrori;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmDatiSocioeconomiciPfErroriPersistenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
public class UplCrmDatiSocioeconomiciPfErroriPersistenceServiceTest {
    @Autowired
    private UplCrmDatiSocioeconomiciPfErroriPersistenceService service;

    private UplCrmDatiSocioeconomiciPfErrori populateUplUplCrmDatiSocioeconomiciPfErrori(UplCrmDatiSocioeconomiciPfErrori datiSocioeconomici) {
        Timestamp timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");
        datiSocioeconomici.setUtenteInserimento("");
        datiSocioeconomici.setIdSoggetto(BigInteger.TEN);
        datiSocioeconomici.setIdDatiSocioeconomiciPfErrori(BigInteger.TEN);
        datiSocioeconomici.setDataInserimento(timestamp);
        datiSocioeconomici.setDataAggiornamento(timestamp);
        datiSocioeconomici.setCompagnia("");
        datiSocioeconomici.setStatocivilef("");
        datiSocioeconomici.setCasamutuof("");
        datiSocioeconomici.setCasaaffittof("");
        datiSocioeconomici.setCasaproprf("");
        datiSocioeconomici.setStatocivilef("");
        datiSocioeconomici.setCasasecondaf("");
        datiSocioeconomici.setFlagfiglif("");
        datiSocioeconomici.setAnnoFiglio1f("");
        datiSocioeconomici.setAnnoFiglio2f("");
        datiSocioeconomici.setAnnoFiglio3f("");
        datiSocioeconomici.setAnnoFiglio4f("");
        datiSocioeconomici.setTitolostudiof("");
        datiSocioeconomici.setTiporisparmiatoref("");
        datiSocioeconomici.setInetsocialf("");
        datiSocioeconomici.setInetlavorof("");
        datiSocioeconomici.setInetapplf("");
        datiSocioeconomici.setInetacquistif("");
        datiSocioeconomici.setInfoassistenzaf("");
        datiSocioeconomici.setInfoereditaf("");
        datiSocioeconomici.setInfointpensf("");
        datiSocioeconomici.setInfointpensf("");
        datiSocioeconomici.setInfoindennizzof("");
        datiSocioeconomici.setInforendcapf("");
        datiSocioeconomici.setInforispautof("");
        datiSocioeconomici.setInforendcapf("");
        datiSocioeconomici.setInfoperditaimpiegof("");
        datiSocioeconomici.setInfoDannif("");
        datiSocioeconomici.setInfoterremotof("");
        datiSocioeconomici.setIntfotof("");
        datiSocioeconomici.setIntmusicaf("");
        datiSocioeconomici.setIntenogasf("");
        datiSocioeconomici.setIntmotorif("");
        datiSocioeconomici.setIntletturaf("");
        datiSocioeconomici.setIntnaturaf("");
        datiSocioeconomici.setIntfotof("");
        datiSocioeconomici.setIntsalutef("");
        datiSocioeconomici.setInttecnof("");
        datiSocioeconomici.setIntfaIdatef("");
        datiSocioeconomici.setIntsportf("");
        datiSocioeconomici.setIntviaggif("");
        datiSocioeconomici.setIntvolontf("");
        datiSocioeconomici.setInforispnorischif("");
        datiSocioeconomici.setInfostudiofiglif("");
        datiSocioeconomici.setPrevcambioautof("");
        datiSocioeconomici.setPrevmutuof("");
        datiSocioeconomici.setPrevpensionef("");
        datiSocioeconomici.setPrevnuovaattf("");
        datiSocioeconomici.setPrevcambiocasaf("");
        datiSocioeconomici.setPrevpromozionef("");
        datiSocioeconomici.setPrevFinestudiofiglif("");
        datiSocioeconomici.setPrevvacanzaf("");
        datiSocioeconomici.setReccellularef("");
        datiSocioeconomici.setRecmailf("");
        datiSocioeconomici.setRecfaxf("");
        datiSocioeconomici.setRectelefonof("");
        datiSocioeconomici.setReccellularef("");
        datiSocioeconomici.setProfessionef("");
        datiSocioeconomici.setFirma1f("");
        datiSocioeconomici.setFirma2f("");
        datiSocioeconomici.setLogerrori("");
        return datiSocioeconomici;
    }

    @Test
    void shouldGenerateDefaultValues() {
        //given
        UplCrmDatiSocioeconomiciPfErrori datiSocioeconomici = populateUplUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());

        //when
        final UplCrmDatiSocioeconomiciPfErrori inserted = service.insertDatiSocioeconomiciPfErrori(datiSocioeconomici);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataInserimento(), "field dataInserimento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() {
        //given
        UplCrmDatiSocioeconomiciPfErrori datiSocioeconomici = populateUplUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());

        //when
        final UplCrmDatiSocioeconomiciPfErrori inserted = service.insertDatiSocioeconomiciPfErrori(datiSocioeconomici);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataAggiornamento(), "field dataInserimento should be generated automatically during insert");
    }
}
