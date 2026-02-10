package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmDatiSocioeconomiciPf;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmDatiSocioeconomiciPfPersistenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
public class UplCrmDatiSocioeconomiciPfPersistenceServiceTest {
    @Autowired
    private UplCrmDatiSocioeconomiciPfPersistenceService service;

    private UplCrmDatiSocioeconomiciPf populateUplCrmDatiSocioeconomiciPf(UplCrmDatiSocioeconomiciPf datiSocioeconomici) {
        Timestamp timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");
        datiSocioeconomici.setUtenteInserimento("");
        datiSocioeconomici.setIdSoggetto(BigInteger.TEN);
        datiSocioeconomici.setIdDatiSocioeconomiciPf(BigInteger.TEN);
        datiSocioeconomici.setDataInserimento(timestamp);
        datiSocioeconomici.setDataAggiornamento(timestamp);
        datiSocioeconomici.setStatocivile("");
        datiSocioeconomici.setCasamutuo("");
        datiSocioeconomici.setCasaaffitto("");
        datiSocioeconomici.setCasapropr("");
        datiSocioeconomici.setStatocivile("");
        datiSocioeconomici.setCasaseconda("");
        datiSocioeconomici.setFlagfigli("");
        datiSocioeconomici.setAnnoFiglio1("");
        datiSocioeconomici.setAnnoFiglio2("");
        datiSocioeconomici.setAnnoFiglio3("");
        datiSocioeconomici.setAnnoFiglio4("");
        datiSocioeconomici.setTitolostudio("");
        datiSocioeconomici.setTiporisparmiatore("");
        datiSocioeconomici.setInetsocial("");
        datiSocioeconomici.setInetlavoro("");
        datiSocioeconomici.setInetappl("");
        datiSocioeconomici.setInetacquisti("");
        datiSocioeconomici.setInfoassistenza("");
        datiSocioeconomici.setInfoeredita("");
        datiSocioeconomici.setInfointpens("");
        datiSocioeconomici.setInfointpens("");
        datiSocioeconomici.setInfoindennizzo("");
        datiSocioeconomici.setInforendcap("");
        datiSocioeconomici.setInforispauto("");
        datiSocioeconomici.setInforendcap("");
        datiSocioeconomici.setInfoperditaimpiego("");
        datiSocioeconomici.setInfoDanni("");
        datiSocioeconomici.setInfoterremoto("");
        datiSocioeconomici.setIntfoto("");
        datiSocioeconomici.setIntmusica("");
        datiSocioeconomici.setIntenogas("");
        datiSocioeconomici.setIntmotori("");
        datiSocioeconomici.setIntlettura("");
        datiSocioeconomici.setIntnatura("");
        datiSocioeconomici.setIntfoto("");
        datiSocioeconomici.setIntsalute("");
        datiSocioeconomici.setInttecno("");
        datiSocioeconomici.setIntfaIdate("");
        datiSocioeconomici.setIntsport("");
        datiSocioeconomici.setIntviaggi("");
        datiSocioeconomici.setIntvolont("");
        datiSocioeconomici.setInforispnorischi("");
        datiSocioeconomici.setInfostudiofigli("");
        datiSocioeconomici.setPrevcambioauto("");
        datiSocioeconomici.setPrevmutuo("");
        datiSocioeconomici.setPrevpensione("");
        datiSocioeconomici.setPrevnuovaatt("");
        datiSocioeconomici.setPrevcambiocasa("");
        datiSocioeconomici.setPrevpromozione("");
        datiSocioeconomici.setPrevFinestudiofigli("");
        datiSocioeconomici.setPrevvacanza("");
        return datiSocioeconomici;
    }

    @Test
    void shouldGenerateDefaultValues() {
        //given
        UplCrmDatiSocioeconomiciPf datiSocioeconomici = populateUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());

        //when
        final UplCrmDatiSocioeconomiciPf inserted = service.insertDatiSocioeconomiciPf(datiSocioeconomici);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataInserimento(), "field dataInserimento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() {
        //given
        UplCrmDatiSocioeconomiciPf datiSocioeconomici = populateUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());

        //when
        final UplCrmDatiSocioeconomiciPf inserted = service.insertDatiSocioeconomiciPf(datiSocioeconomici);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataAggiornamento(), "field dataInserimento should be generated automatically during insert");
    }
}
