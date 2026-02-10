package it.unipol.crm.anagrafica.gestione.service.code;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmIndirizzi;
import it.unipol.crm.anagrafica.gestione.service.entities.UplCrmIndirizziPersistenceService;
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
public class UplCrmIndirizziPersistenceServiceTest {
    @Autowired
    private UplCrmIndirizziPersistenceService service;
    private UplCrmIndirizzi populateUplCrmIndirizzi(UplCrmIndirizzi indirizzi) {
        Timestamp timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");
        indirizzi.setUtenteInserimento("");
        indirizzi.setIdSoggetto(BigInteger.TEN);
        indirizzi.setDataInizio(timestamp);
        indirizzi.setNazione(BigInteger.TEN);
        indirizzi.setFlagProvenienzaBanca(BigInteger.TEN);
        indirizzi.setSiglaProvincia(BigInteger.TEN);
        indirizzi.setTipoindirizzo(BigInteger.TEN);
        indirizzi.setIndirizzo("");
        indirizzi.setComune("");
        indirizzi.setTipoaddress("");
        return indirizzi;
    }
    @Test
    void shouldGenerateDefaultValues() {
        //given
        UplCrmIndirizzi indirizzi = populateUplCrmIndirizzi(new UplCrmIndirizzi());

        //when
        final UplCrmIndirizzi inserted = service.insertIndirizzi(indirizzi);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getDataAggiornamento(), "field dataAggiornamento should be generated automatically during insert");
        assertNotNull(inserted.getDataInserimento(), "field dataInserimento should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() {
        //given
        UplCrmIndirizzi indirizzi = populateUplCrmIndirizzi(new UplCrmIndirizzi());

        //when
        final UplCrmIndirizzi inserted = service.insertIndirizzi(indirizzi);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotEquals( Timestamp.valueOf("2022-08-10 12:00:00.000"), inserted.getDataAggiornamento(), "persistence service should overwrite the given value for that field");
    }
}
