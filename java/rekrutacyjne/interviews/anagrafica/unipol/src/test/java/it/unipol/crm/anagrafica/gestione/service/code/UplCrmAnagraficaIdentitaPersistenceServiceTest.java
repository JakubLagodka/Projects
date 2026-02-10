package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagraficaIdentita;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmAnagraficaIdentitaPersistenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
public class UplCrmAnagraficaIdentitaPersistenceServiceTest {
    @Autowired
    private UplCrmAnagraficaIdentitaPersistenceService service;

    private UplCrmAnagraficaIdentita populateUplCrmAnagraficaIdentita(UplCrmAnagraficaIdentita anagraficaIdentita) {
        anagraficaIdentita.setIdSoggetto(BigInteger.TEN);
        anagraficaIdentita.setCodicetipo(BigInteger.TEN);
        anagraficaIdentita.setUtenteInserimento("");
        return anagraficaIdentita;
    }

    @Test
    void shouldGenerateDefaultValues() throws ParseException {
        //given
        UplCrmAnagraficaIdentita anagraficaIdentita = populateUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());

        //when
        final UplCrmAnagraficaIdentita inserted = service.insertAnagraficaIdentita(anagraficaIdentita);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataAggiornamento(), "field dataAggiornamento should be generated automatically during insert");
        assertNotNull(inserted.getDataInserimento(), "field dataInserimento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() throws ParseException {
        //given
        UplCrmAnagraficaIdentita anagraficaIdentita = populateUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());

        //when
        final UplCrmAnagraficaIdentita inserted = service.insertAnagraficaIdentita(anagraficaIdentita);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotEquals(Timestamp.valueOf("2022-08-10 12:00:00.000"), inserted.getDataAggiornamento(), "persistence service should overwrite the given value for that field");
    }
}
