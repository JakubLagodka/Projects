package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagRel;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmAnagRelPersistenceService;
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
public class UplCrmAnagRelPersistenceServiceTest {
    @Autowired
    private UplCrmAnagRelPersistenceService service;
    private UplCrmAnagRel populateUplCrmAnagRel(UplCrmAnagRel anagRel) {
        Timestamp timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");

        anagRel.setCodicetiporelazione(BigInteger.TEN);
        anagRel.setContIdarrivo(BigInteger.TEN);
        anagRel.setContIdpartenza(BigInteger.TEN);
        anagRel.setDataInizio(timestamp);
        anagRel.setUtenteInserimento("");
        return anagRel;
    }
    @Test
    void shouldGenerateDefaultValues() throws ParseException {
        //given
        UplCrmAnagRel anagRel = populateUplCrmAnagRel(new UplCrmAnagRel());

        //when
        final UplCrmAnagRel inserted = service.insertAnagRel(anagRel);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataAggiornamento(), "field dataAggiornamento should be generated automatically during insert");
        assertNotNull(inserted.getDataInserimento(), "field dataInserimento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() throws ParseException {
        //given
        UplCrmAnagRel anagRel = populateUplCrmAnagRel(new UplCrmAnagRel());

        //when
        final UplCrmAnagRel inserted = service.insertAnagRel(anagRel);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotEquals( Timestamp.valueOf("2022-08-10 12:00:00.000"), inserted.getDataAggiornamento(), "persistence service should overwrite the given value for that field");
    }
}
