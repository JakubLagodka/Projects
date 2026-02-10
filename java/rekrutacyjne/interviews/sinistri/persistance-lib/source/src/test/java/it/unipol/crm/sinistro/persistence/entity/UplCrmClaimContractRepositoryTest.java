package it.unipol.crm.sinistro.persistence.entity;

import it.unipol.crm.sinistro.persistence.DatabasePopulator;
import it.unipol.crm.sinistro.persistence.configuration.DatabaseConfiguration;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContractRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
class UplCrmClaimContractRepositoryTest {
    @Autowired
    private UplCrmClaimContractRepository repository;

    @Autowired
    private DatabasePopulator databasePopulator;

    @Test
    void shouldGetUplCrmClaimContract() {
        //given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        var id = BigInteger.valueOf(1);

        //when
        var actual = repository.findById(id);

        //then
        assertTrue(actual.isPresent(), "Should find one.");
    }

    @Test
    void shouldGetUplCrmClaimContractByClaimId() {
        //given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        var id = BigInteger.valueOf(1);

        //when
        var actual = repository.findByClaimId(id);

        //then
        assertNotNull(actual, "Should find one.");
    }

    @Test
    void shouldGetContractIdFromContract() {
        //given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        var id = BigInteger.valueOf(1);

        //when
        var actual = repository.findContractId(id);

        //then
        assertNotNull(actual, "Should find one.");
    }
}