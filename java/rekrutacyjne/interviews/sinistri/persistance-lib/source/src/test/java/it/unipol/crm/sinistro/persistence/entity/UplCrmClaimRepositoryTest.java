package it.unipol.crm.sinistro.persistence.entity;

import it.unipol.crm.sinistro.persistence.DatabasePopulator;
import it.unipol.crm.sinistro.persistence.configuration.DatabaseConfiguration;
import it.unipol.crm.sinistro.persistence.entity.claim.UplCrmClaimRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
class UplCrmClaimRepositoryTest {
    @Autowired
    private UplCrmClaimRepository repository;

    @Autowired
    private DatabasePopulator databasePopulator;

    @Test
    void shouldGetUplCrmClaim() {
        //given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        var id = BigInteger.valueOf(1);

        //when
        var actual = repository.findById(id);

        //then
        assertTrue(actual.isPresent(), "Should find one.");
    }

    @Test
    void shouldGetUplCrmClaimListByAdminRefNumAndContattoIdAndContrattoIdAndReportedDtBetween() {
        //given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        var adminRefNum = "120180890000419014";
        var contattoId = BigInteger.ONE;
        var contrattoId = BigInteger.ONE;
        var reportedDtStart = Timestamp.valueOf("2017-10-19 00:00:00");
        var reportedDtEnd = Timestamp.valueOf("2017-10-21 00:00:00");

        Pageable pageable = PageRequest.of(0, 20);

        //when
        var actual = repository.findAllByAdminRefNumAndContattoIdAndContrattoIdAndReportedDtBetween
                (adminRefNum, contattoId, contrattoId, reportedDtStart, reportedDtEnd, pageable);

        //then
        assertNotNull(actual, "Should find one.");
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
    }

    @Test
    void shouldGetUplCrmClaimListByContattoId() {
        //given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        var contattoId = BigInteger.ONE;

        Pageable pageable = PageRequest.of(0, 20);

        //when
        var actual = repository.findAllByAdminRefNumAndContattoIdAndContrattoIdAndReportedDtBetween
                (null, contattoId, null, null, null, pageable);

        //then
        assertNotNull(actual, "Should find one.");
        assertFalse(actual.isEmpty());
        assertEquals(4, actual.size());
    }
}