package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmDocumenti;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmDocumentiPersistenceService;
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
public class UplCrmDocumentiPersistenceServiceTest {
    @Autowired
    private UplCrmDocumentiPersistenceService service;
    private UplCrmDocumenti populateUplCrmDocumenti(UplCrmDocumenti documenti) {
        Timestamp timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");
        documenti.setUtenteInserimento("");
        documenti.setCodicetipodocumento(BigInteger.TEN);
        documenti.setIdSoggetto(BigInteger.TEN);
        documenti.setCodicestatodocumento(BigInteger.TEN);
        documenti.setDataInizio(timestamp);
        documenti.setDatascadenza(timestamp);
        return documenti;
    }
    @Test
    void shouldGenerateDefaultValues() {
        //given
        UplCrmDocumenti documenti = populateUplCrmDocumenti(new UplCrmDocumenti());

        //when
        final UplCrmDocumenti inserted = service.insertDocumenti(documenti);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataAggiornamento(), "field dataAggiornamento should be generated automatically during insert");
        assertNotNull(inserted.getDataInserimento(), "field dataInserimento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() {
        //given
        UplCrmDocumenti documenti = populateUplCrmDocumenti(new UplCrmDocumenti());

        //when
        final UplCrmDocumenti inserted = service.insertDocumenti(documenti);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotEquals( Timestamp.valueOf("2022-08-10 12:00:00.000"), inserted.getDataAggiornamento(), "persistence service should overwrite the given value for that field");
    }
}
