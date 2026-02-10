package it.unipol.crm.sinistro.persistence.service;

import it.unipol.crm.sinistro.persistence.DatabasePopulator;
import it.unipol.crm.sinistro.persistence.configuration.DatabaseConfiguration;
import it.unipol.crm.sinistro.persistence.entity.claim.UplCrmClaim;
import it.unipol.crm.sinistro.persistence.entity.claim.UplCrmClaimRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
class UplCrmClaimPersistenceServiceTest {
    @Autowired
    private UplCrmClaimRepository repository;

    @Autowired
    private UplCrmClaimPersistenceService service;

    @Autowired
    private DatabasePopulator databasePopulator;

    @Test
    void shouldGenerateDefaultValues() {
        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        UplCrmClaim minimalClaim = new UplCrmClaim();
        minimalClaim.setClaimId(BigInteger.ONE);
        minimalClaim.setClaimTpCd(BigInteger.valueOf(1001));

        // when
        final UplCrmClaim inserted = service.insertClaim(minimalClaim);

        // then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getLastUpdateDt(), "field LastUpdateDt should be generated automatically during insert");
    }

    @Test
    void shouldOverwriteDefaultValue() {
        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        Timestamp now = Timestamp.valueOf("2022-08-10 12:00:00.000");

        UplCrmClaim minimalClaim = new UplCrmClaim();
        minimalClaim.setClaimId(BigInteger.ONE);
        minimalClaim.setClaimTpCd(BigInteger.valueOf(1001));
        minimalClaim.setLastUpdateDt(now);

        // when
        final UplCrmClaim inserted = service.insertClaim(minimalClaim);

        // then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getLastUpdateDt(), "field LastUpdateDt should be generated automatically during insert");
        assertNotEquals(now, inserted.getLastUpdateDt(), "persistence service should overwrite the given value for that field");
    }

    @Test
    void shouldThrowExceptionForNullValue() {
        // given
        UplCrmClaim invalidClaim = new UplCrmClaim();
        invalidClaim.setClaimTpCd(null);

        // then
        assertThrows(IllegalArgumentException.class, () -> service.insertClaim(invalidClaim));
    }
}