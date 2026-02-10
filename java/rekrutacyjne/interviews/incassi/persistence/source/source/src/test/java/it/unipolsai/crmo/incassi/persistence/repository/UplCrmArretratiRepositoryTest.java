package it.unipolsai.crmo.incassi.persistence.repository;

import it.unipolsai.crmo.incassi.persistence.config.DatabaseConfiguration;
import it.unipolsai.crmo.incassi.persistence.config.DatabasePopulator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DatabaseConfiguration.class)
class UplCrmArretratiRepositoryTest {

    @Autowired
    DatabasePopulator databasePopulator;
    @Autowired
    UplCrmArretratiRepository repository;

    @BeforeEach
    void populateDB() {
        databasePopulator.populateDatabaseBeforeTestsInClass();
    }

    @Test
    void shouldGetUplCrmArretrati() {
        //given
        var id = BigInteger.ONE;

        //when
        var actual = repository.findById(id);

        //then
        assertTrue(actual.isPresent(), "Should find one.");
    }

    @Test
    void shouldGetUplCrmArretratiByIdTitoloAndNumeroArchivio() {
        //given
        var idTitolo = "1";
        var idFolder = BigInteger.ONE;

        //when
        var actual = repository.findByIdTitoloAndIdFolder(idTitolo, idFolder);
        //then
        assertTrue(actual.isPresent(), "Should find one.");
    }

}