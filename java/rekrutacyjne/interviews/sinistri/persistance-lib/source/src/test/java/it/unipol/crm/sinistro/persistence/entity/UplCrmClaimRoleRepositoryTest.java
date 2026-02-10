package it.unipol.crm.sinistro.persistence.entity;

import it.unipol.crm.sinistro.persistence.DatabasePopulator;
import it.unipol.crm.sinistro.persistence.configuration.DatabaseConfiguration;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
class UplCrmClaimRoleRepositoryTest {
    @Autowired
    private UplCrmClaimRoleRepository repository;

    @Autowired
    private DatabasePopulator databasePopulator;

    @Test
    void shouldGetUplCrmClaimRole() {
        //given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        var id = BigInteger.valueOf(1);

        //when
        var actual = repository.findById(id);

        //then
        assertTrue(actual.isPresent(), "Should find one.");
    }

    @Test
    void shouldGetUplCrmClaimRoleByClaimId() {
        //given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        var id = BigInteger.valueOf(1);

        //when
        var actual = repository.findByClaimId(id);

        //then
        assertNotNull(actual, "Should find one.");
    }

    @Test
    void shouldGetContactIdFromContact() {
        //given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        var id = BigInteger.valueOf(1);

        //when
        var actual = repository.findContactId(id);

        //then
        assertNotNull(actual, "Should find one.");
    }
}