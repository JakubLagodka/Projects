package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagrafichePg;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmAnagrafichePgPersistenceService;
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
public class UplCrmAnagrafichePgPersistenceServiceTest {
    @Autowired
    private UplCrmAnagrafichePgPersistenceService service;
    private UplCrmAnagrafichePg populateUplCrmAnagrafichePg(UplCrmAnagrafichePg anagrafichePg) {
        Timestamp timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");

        anagrafichePg.setDataAggiornamento(timestamp);
        anagrafichePg.setCodiceramo(BigInteger.ONE);
        anagrafichePg.setCodicesettore(BigInteger.ONE);
        anagrafichePg.setDatacostituzione(timestamp);
        anagrafichePg.setCodicemercatopreferenziale(BigInteger.TEN);
        anagrafichePg.setIdSoggetto(BigInteger.ONE);
        anagrafichePg.setDataInserimento(timestamp);
        anagrafichePg.setUtenteInserimento("");
        return anagrafichePg;
    }
    @Test
    void shouldGenerateDefaultValues() throws ParseException {
        //given
        UplCrmAnagrafichePg anagrafichePg = populateUplCrmAnagrafichePg(new UplCrmAnagrafichePg());

        //when
        final UplCrmAnagrafichePg inserted = service.insertAnagrafichePg(anagrafichePg);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataAggiornamento(), "field dataAggiornamento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() throws ParseException {
        //given
        UplCrmAnagrafichePg anagrafichePg = populateUplCrmAnagrafichePg(new UplCrmAnagrafichePg());

        //when
        final UplCrmAnagrafichePg inserted = service.insertAnagrafichePg(anagrafichePg);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotEquals(Timestamp.valueOf("2022-08-10 12:00:00.000"), inserted.getDataAggiornamento(), "persistence service should overwrite the given value for that field");
    }
}
