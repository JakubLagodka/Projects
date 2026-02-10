package it.unipol.crm.sinistro.persistence.service;

import it.unipol.crm.sinistro.persistence.DatabasePopulator;
import it.unipol.crm.sinistro.persistence.configuration.DatabaseConfiguration;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContract;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContractRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
class UplCrmClaimContractPersistenceServiceTest {
    @Autowired
    private UplCrmClaimContractRepository repository;

    @Autowired
    private UplCrmClaimContractPersistenceService service;

    @Autowired
    private DatabasePopulator databasePopulator;

    @Test
    void shouldGenerateDefaultValues() {
        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        UplCrmClaimContract minimalClaimContract = new UplCrmClaimContract();
        minimalClaimContract.setClaimContrId(BigInteger.ONE);
        minimalClaimContract.setClaimId(BigInteger.ONE);
        minimalClaimContract.setContractId(BigInteger.ONE);

        // when
        final UplCrmClaimContract inserted = service.insertClaimContract(minimalClaimContract);

        // then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getLastUpdateDt(), "field LastUpdateDt should be generated automatically during insert");
    }

    @Test
    void shouldOverwriteDefaultValue() {
        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        Timestamp now = Timestamp.valueOf("2022-08-10 12:00:00.000");

        UplCrmClaimContract minimalClaimContract = new UplCrmClaimContract();
        minimalClaimContract.setClaimContrId(BigInteger.ONE);
        minimalClaimContract.setClaimId(BigInteger.ONE);
        minimalClaimContract.setContractId(BigInteger.ONE);
        minimalClaimContract.setLastUpdateDt(now);

        // when
        final UplCrmClaimContract inserted = service.insertClaimContract(minimalClaimContract);

        // then
        assertNotNull(inserted, "inserted object shouldn't be null");
        assertNotNull(inserted.getLastUpdateDt(), "field LastUpdateDt should be generated automatically during insert");
        assertNotEquals(now, inserted.getLastUpdateDt(), "persistence service should overwrite the given value for that field");
    }

    @Test
    void shouldThrowExceptionForNullClaimId() {
        // given
        UplCrmClaimContract invalidClaimContract = new UplCrmClaimContract();
        invalidClaimContract.setClaimId(BigInteger.ONE);
        invalidClaimContract.setContractId(null);

        // then
        assertThrows(IllegalArgumentException.class, () -> service.insertClaimContract(invalidClaimContract));
    }

    @Test
    void shouldThrowExceptionForNullContractId() {
        // given
        UplCrmClaimContract invalidClaimContract = new UplCrmClaimContract();
        invalidClaimContract.setClaimId(null);
        invalidClaimContract.setContractId(BigInteger.ONE);

        // then
        assertThrows(IllegalArgumentException.class, () -> service.insertClaimContract(invalidClaimContract));
    }
}