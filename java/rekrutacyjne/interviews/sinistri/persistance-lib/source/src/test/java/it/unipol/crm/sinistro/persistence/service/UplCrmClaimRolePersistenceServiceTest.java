package it.unipol.crm.sinistro.persistence.service;

import it.unipol.crm.sinistro.persistence.DatabasePopulator;
import it.unipol.crm.sinistro.persistence.configuration.DatabaseConfiguration;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRole;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
class UplCrmClaimRolePersistenceServiceTest {
    @Autowired
    private UplCrmClaimRoleRepository repository;

    @Autowired
    private UplCrmClaimRolePersistenceService service;

    @Autowired
    private DatabasePopulator databasePopulator;

    @Test
    void shouldGenerateDefaultValues() {
        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        UplCrmClaimRole minimalClaimRole = new UplCrmClaimRole();
        minimalClaimRole.setClaimRoleId(BigInteger.ONE);
        minimalClaimRole.setClaimId(BigInteger.ONE);
        minimalClaimRole.setContId(BigInteger.ONE);
        minimalClaimRole.setClaimRoleTpCd(BigInteger.valueOf(1001));

        // when
        final UplCrmClaimRole inserted = service.insertClaimRole(minimalClaimRole);

        // then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getLastUpdateDt(), "field LastUpdateDt should be generated automatically during insert ");
    }

    @Test
    void shouldOverwriteDefaultValue() {
        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        Timestamp now = Timestamp.valueOf("2022-08-10 12:00:00.000");

        UplCrmClaimRole minimalClaimRole = new UplCrmClaimRole();
        minimalClaimRole.setClaimRoleId(BigInteger.ONE);
        minimalClaimRole.setClaimId(BigInteger.ONE);
        minimalClaimRole.setContId(BigInteger.ONE);
        minimalClaimRole.setClaimRoleTpCd(BigInteger.valueOf(1001));
        minimalClaimRole.setLastUpdateDt(now);

        // when
        final UplCrmClaimRole inserted = service.insertClaimRole(minimalClaimRole);

        // then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getLastUpdateDt(), "field LastUpdateDt should be generated automatically during insert");
        assertNotEquals(now, inserted.getLastUpdateDt(), "persistence service should overwrite the given value for that field");
    }

    @Test
    void shouldThrowExceptionForNullContId() {
        // given
        UplCrmClaimRole invalidClaimRole = new UplCrmClaimRole();
        invalidClaimRole.setContId(null);
        invalidClaimRole.setClaimId(BigInteger.ONE);
        invalidClaimRole.setClaimRoleTpCd(BigInteger.ONE);

        // then
        assertThrows(IllegalArgumentException.class, () -> service.insertClaimRole(invalidClaimRole));
    }

    @Test
    void shouldThrowExceptionForNullClaimId() {
        // given
        UplCrmClaimRole invalidClaimRole = new UplCrmClaimRole();
        invalidClaimRole.setContId(BigInteger.ONE);
        invalidClaimRole.setClaimId(null);
        invalidClaimRole.setClaimRoleTpCd(BigInteger.ONE);

        // then
        assertThrows(IllegalArgumentException.class, () -> service.insertClaimRole(invalidClaimRole));
    }

    @Test
    void shouldThrowExceptionForNullClaimRoleTpCd() {
        // given
        UplCrmClaimRole invalidClaimRole = new UplCrmClaimRole();
        invalidClaimRole.setContId(BigInteger.ONE);
        invalidClaimRole.setClaimId(BigInteger.ONE);
        invalidClaimRole.setClaimRoleTpCd(null);

        // then
        assertThrows(IllegalArgumentException.class, () -> service.insertClaimRole(invalidClaimRole));
    }
}