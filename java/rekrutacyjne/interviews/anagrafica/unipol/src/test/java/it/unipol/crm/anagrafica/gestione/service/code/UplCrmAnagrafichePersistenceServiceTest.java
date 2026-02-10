package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagrafiche;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmAnagrafichePersistenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
public class UplCrmAnagrafichePersistenceServiceTest {
    @Autowired
    private UplCrmAnagrafichePersistenceService service;
    private UplCrmAnagrafiche populateUplCrmAnagrafiche(UplCrmAnagrafiche anagrafiche) throws ParseException {
        Timestamp timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");
        var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(dateFormat.parse("2022-08-10 12:00:00.000").getTime());

        anagrafiche.setTipondg(BigInteger.TEN);
        anagrafiche.setCodicelinguapreferita(BigInteger.ONE);
        anagrafiche.setDatacreazione(timestamp);
        anagrafiche.setCodicesegmentoclientela(BigInteger.TEN);
        anagrafiche.setCodicestatocliente(BigInteger.TEN);
        anagrafiche.setCodicetipoanagrafe(BigInteger.TEN);
        anagrafiche.setCodiceprofessione(BigInteger.TEN);
        anagrafiche.setCodicetiposofferenza(BigInteger.TEN);
        anagrafiche.setDataregistrazione(timestamp);
        anagrafiche.setConsensobanca(BigInteger.TEN);
        anagrafiche.setConsensoassic(BigInteger.TEN);
        anagrafiche.setIncagliosofferenza(BigInteger.TEN);
        anagrafiche.setConstpcd(BigInteger.TEN);
        anagrafiche.setCanaletpcd(BigInteger.TEN);
        anagrafiche.setDataAggiornamento(timestamp);
        anagrafiche.setDataInserimento(timestamp);
        anagrafiche.setDataregconsensoassicts(timestamp);
        anagrafiche.setDataautorizzazionefea(date.toLocalDate());
        anagrafiche.setDataconsensoassicts(timestamp);
        anagrafiche.setDatarevocaconsensoassicts(timestamp);
        anagrafiche.setDatarifiutoloyaltyprogram(timestamp);
        anagrafiche.setCanaletpcd(BigInteger.TEN);
        anagrafiche.setUtenteInserimento("");
        anagrafiche.setTipopersona("");
        return anagrafiche;
    }
    @Test
    void shouldGenerateDefaultValues() throws ParseException {
        //given
        UplCrmAnagrafiche anagrafiche = populateUplCrmAnagrafiche(new UplCrmAnagrafiche());

        //when
        final UplCrmAnagrafiche inserted = service.insertAnagrafiche(anagrafiche);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataAggiornamento(), "field dataAggiornamento should be generated automatically during insert");
        assertNotNull(inserted.getDataInserimento(), "field dataInserimento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() throws ParseException {
        //given
        UplCrmAnagrafiche anagrafiche =  populateUplCrmAnagrafiche(new UplCrmAnagrafiche());

        //when
        final UplCrmAnagrafiche inserted = service.insertAnagrafiche(anagrafiche);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotEquals(Timestamp.valueOf("2022-08-10 12:00:00.000"), inserted.getDataAggiornamento(), "persistence service should overwrite the given value for that field");
    }
}
