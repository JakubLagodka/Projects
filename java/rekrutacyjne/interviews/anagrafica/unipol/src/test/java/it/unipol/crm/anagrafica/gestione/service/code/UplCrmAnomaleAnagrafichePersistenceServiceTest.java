package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnomalieAnagrafiche;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmAnomalieAnagrafichePersistenceService;
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
public class UplCrmAnomaleAnagrafichePersistenceServiceTest {
    @Autowired
    private UplCrmAnomalieAnagrafichePersistenceService service;
    private UplCrmAnomalieAnagrafiche populateUplCrmAnomaleAnagrafiche(UplCrmAnomalieAnagrafiche anomaleAnagrafiche)  {
        Timestamp timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");

        anomaleAnagrafiche.setDataInizio(timestamp);
        anomaleAnagrafiche.setUtenteInserimento("");
        anomaleAnagrafiche.setIdSoggetto(BigInteger.TEN);
        anomaleAnagrafiche.setCodicetipoanomalia(BigInteger.TEN);
        anomaleAnagrafiche.setCodicestatoanomalia(BigInteger.TEN);
        return anomaleAnagrafiche;
    }
    @Test
    void shouldGenerateDefaultValues() throws ParseException {
        //given
        UplCrmAnomalieAnagrafiche anomaleAnagrafiche = populateUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());

        //when
        final UplCrmAnomalieAnagrafiche inserted = service.insertAnomaleAnagrafiche(anomaleAnagrafiche);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataAggiornamento(), "field dataAggiornamento should be generated automatically during insert");
        assertNotNull(inserted.getDataInserimento(), "field dataInserimento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() throws ParseException {
        //given
        UplCrmAnomalieAnagrafiche anomaleAnagrafiche = populateUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());

        //when
        final UplCrmAnomalieAnagrafiche inserted = service.insertAnomaleAnagrafiche(anomaleAnagrafiche);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotEquals( Timestamp.valueOf("2022-08-10 12:00:00.000"), inserted.getDataAggiornamento(), "persistence service should overwrite the given value for that field");
    }
}
