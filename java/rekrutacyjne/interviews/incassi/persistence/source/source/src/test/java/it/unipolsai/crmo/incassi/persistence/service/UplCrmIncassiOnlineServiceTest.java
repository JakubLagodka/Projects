package it.unipolsai.crmo.incassi.persistence.service;

import it.unipolsai.crmo.incassi.persistence.config.DatabaseConfiguration;
import it.unipolsai.crmo.incassi.persistence.config.DatabasePopulator;
import it.unipolsai.crmo.incassi.persistence.entity.UplCrmIncassiOnline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
class UplCrmIncassiOnlineServiceTest {

    @Autowired
    DatabasePopulator databasePopulator;
    @Autowired
    UplCrmIncassiOnlineService service;

    @BeforeEach
    void populateDB() {
        databasePopulator.populateDatabaseBeforeTestsInClass();
    }

    @Test
    void shouldGenerateDefaultValues() {
        //given

        var uplCrmIncassiOnline = new UplCrmIncassiOnline();

        //when
        final var inserted = service.insertIncassiOnline(uplCrmIncassiOnline);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getLastUpdateDt(), "field lastUpdateDt should be generated automatically during insert");
    }

    @Test
    void shouldOverrideDefaultValues() {
        //given

        var timestamp = Timestamp.valueOf("2022-08-10 12:00:00.000");

        var uplCrmIncassiOnline = new UplCrmIncassiOnline();

        uplCrmIncassiOnline.setLastUpdateDt(timestamp);

        //when
        final var inserted = service.insertIncassiOnline(uplCrmIncassiOnline);

        //then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotEquals(timestamp, inserted.getLastUpdateDt(), "persistence service should overwrite the given value for that field");
    }

    @Test
    void shouldGetIdIncassoFindedByIdSecurityAndFolderCode() {
        //given

        var idTitolo = "1";
        var folderCode= "1";

        // when
        var actual =  service.getIdIncassoFindedByIdSecurityAndFolderCode(idTitolo, folderCode);

        //then
        assertNotNull(actual, "Should find one.");
    }
}