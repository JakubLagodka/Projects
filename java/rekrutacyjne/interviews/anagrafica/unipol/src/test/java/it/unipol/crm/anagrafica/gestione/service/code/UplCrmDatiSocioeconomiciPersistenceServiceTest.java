package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmDatiSocioeconomici;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmDatiSocioeconomiciPersistenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
public class UplCrmDatiSocioeconomiciPersistenceServiceTest {
    @Autowired
    private UplCrmDatiSocioeconomiciPersistenceService service;
    private UplCrmDatiSocioeconomici populateUplCrmDatiSocioeconomici(UplCrmDatiSocioeconomici datiSocioeconomici) {
        Timestamp timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");
        datiSocioeconomici.setUtenteInserimento("");
        datiSocioeconomici.setIdSoggetto(BigInteger.TEN);
        datiSocioeconomici.setIdentitariferita(BigInteger.TEN);
        datiSocioeconomici.setIdDatiSocioeconomici(BigInteger.TEN);
        datiSocioeconomici.setDataInserimento(timestamp);
        datiSocioeconomici.setDataAggiornamento(timestamp);
        datiSocioeconomici.setCompagnia("");
        datiSocioeconomici.setNomeentitariferita("");
        return datiSocioeconomici;
    }

    @Test
    void shouldGenerateDefaultValues() {
        //given
        UplCrmDatiSocioeconomici datiSocioeconomici = populateUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());

        //when
        final UplCrmDatiSocioeconomici inserted = service.insertDatiSocioeconomici(datiSocioeconomici);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataInserimento(), "field dataInserimento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() {
        //given
        UplCrmDatiSocioeconomici datiSocioeconomici = populateUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());

        //when
        final UplCrmDatiSocioeconomici inserted = service.insertDatiSocioeconomici(datiSocioeconomici);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataAggiornamento(), "field dataInserimento should be generated automatically during insert");
    }
}
