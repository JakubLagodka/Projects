package it.unipolsai.crmo.incassi.persistence.service;

import it.unipolsai.crmo.incassi.persistence.config.DatabaseConfiguration;
import it.unipolsai.crmo.incassi.persistence.config.DatabasePopulator;
import it.unipolsai.crmo.incassi.persistence.entity.UplCrmArretratiRett;
import it.unipolsai.crmo.incassi.persistence.repository.UplCrmArretratiRettRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
class UplCrmArretratiRettServiceTest {

    @Autowired
    DatabasePopulator databasePopulator;
    @Autowired
    UplCrmArretratiRettService service;
    @Autowired
    UplCrmArretratiRettRepository repository;

    @BeforeEach
    void populateDB() {
        databasePopulator.populateDatabaseBeforeTestsInClass();
    }

    @Test
    void shouldGenerateDefaultValues() {
        //given

        var uplCrmArretrati = new UplCrmArretratiRett();

        //when
        final var inserted = service.insertArretratiRett(uplCrmArretrati);

        //then
        Assertions.assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getLastUpdateDt(), "field lastUpdateDt should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() {
        //given

        var timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");

        var uplCrmArretrati = new UplCrmArretratiRett();

        uplCrmArretrati.setLastUpdateDt(timestamp);

        //when
        final var inserted = service.insertArretratiRett(uplCrmArretrati);

        //then
        Assertions.assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotEquals(timestamp, inserted.getLastUpdateDt(), "persistence service should overwrite the given value for that field");
    }

    @Test
    void shouldGetIdArrettratoFindedByIdSecurityAndFolderCode() {
        //given

        var idSecurity = "1";
        var folderCode= "1";

        // when
        var actual =  service.getIdArretratoRettFindedByIdSecurityAndFolderCode(idSecurity, folderCode);

        //then
        assertNotNull(actual, "Should find one.");
    }

    @Test
    void shouldDeleteArretrato() {
        //given

        var idArretrato = BigInteger.ONE;

        assertTrue(repository.findById(idArretrato).isPresent(), "Should find one.");

        // when
        service.deleteArretratiRett(idArretrato);

        // then
        assertFalse(repository.findById(idArretrato).isPresent(), "Should find not one.");
    }

}