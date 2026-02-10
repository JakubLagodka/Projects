package it.unipolsai.crmo.incassi.persistence.repository;

import it.unipolsai.crmo.incassi.persistence.config.DatabaseConfiguration;
import it.unipolsai.crmo.incassi.persistence.config.DatabasePopulator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
class UplCrmIncassiOnlineRepositoryTest {

    @Autowired
    DatabasePopulator databasePopulator;

    @Autowired
    UplCrmIncassiOnlineRepository repository;

    @BeforeEach
    void populateDB() {
        databasePopulator.populateDatabaseBeforeTestsInClass();
    }

    @Test
    void shouldGetUplCrmIncassiOnline() {
        //given
        var id = BigInteger.ONE;

        //when
        var actual = repository.findById(id);

        //then
        assertTrue(actual.isPresent(), "Should find one.");
    }

    @Test
    void shouldGetUplCrmIncassiOnlineByIdTitoloAndNumeroArchivio() {
        //given
        var idTitolo = "1";
        var folderCode= BigInteger.ONE;

        //when
        var actual = repository.findByTitoloIdAndIdFolder(idTitolo, folderCode);

        //then
        assertTrue(actual.isPresent(), "Should find one.");
    }

}