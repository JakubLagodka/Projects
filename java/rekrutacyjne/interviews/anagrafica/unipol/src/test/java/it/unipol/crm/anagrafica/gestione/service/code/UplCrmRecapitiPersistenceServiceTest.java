package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmRecapiti;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmRecapitiPersistenceService;
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
public class UplCrmRecapitiPersistenceServiceTest {
    @Autowired
    private UplCrmRecapitiPersistenceService service;
    private UplCrmRecapiti populateUplCrmRecapiti(UplCrmRecapiti recapiti) {
        Timestamp timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");
        recapiti.setUtenteInserimento("");
        recapiti.setDataInizio(timestamp);
        recapiti.setIdSoggetto(BigInteger.TEN);
        recapiti.setCodicetiporecapito(BigInteger.TEN);
        recapiti.setRecapito("");
        recapiti.setCodiceusorecapito(BigInteger.TEN);
        return recapiti;
    }

    @Test
    void shouldGenerateDefaultValues() {
        //given
        UplCrmRecapiti recapiti = populateUplCrmRecapiti(new UplCrmRecapiti());

        //when
        final UplCrmRecapiti inserted = service.insertRecapiti(recapiti);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataInserimento(), "field dataInserimento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() {
        //given
        UplCrmRecapiti recapiti = populateUplCrmRecapiti(new UplCrmRecapiti());

        //when
        final UplCrmRecapiti inserted = service.insertRecapiti(recapiti);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotEquals(Timestamp.valueOf("2022-08-10 12:00:00.000"), inserted.getDataAggiornamento(), "persistence service should overwrite the given value for that field");
    }
}
