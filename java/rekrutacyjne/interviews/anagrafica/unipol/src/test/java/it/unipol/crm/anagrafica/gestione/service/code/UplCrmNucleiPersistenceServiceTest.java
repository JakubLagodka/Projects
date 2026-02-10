package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmNuclei;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmNucleiPersistenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
public class UplCrmNucleiPersistenceServiceTest {
    @Autowired
    private UplCrmNucleiPersistenceService service;
    private UplCrmNuclei populateUplCrmNuclei(UplCrmNuclei nuclei) {
        Timestamp timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");
        nuclei.setUtenteInserimento("");
        nuclei.setDataInizio(timestamp);
        nuclei.setIdSoggettocapogruppo("");
        nuclei.setCodicetiponucleo(BigInteger.TEN);
        nuclei.setContact("");

        return nuclei;
    }
    @Test
    void shouldGenerateDefaultValues() {
        //given
        UplCrmNuclei nuclei = populateUplCrmNuclei(new UplCrmNuclei());

        //when
        final UplCrmNuclei inserted = service.insertNuclei(nuclei);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataAggiornamento(), "field dataAggiornamento should be generated automatically during insert");
        assertNotNull(inserted.getDataInserimento(), "field dataInserimento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() {
        //given
        UplCrmNuclei nuclei = populateUplCrmNuclei(new UplCrmNuclei());

        //when
        final UplCrmNuclei inserted = service.insertNuclei(nuclei);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotEquals( Timestamp.valueOf("2022-08-10 12:00:00.000"), inserted.getDataAggiornamento(), "persistence service should overwrite the given value for that field");
    }
}
