package it.unipol.crm.sinistro.service;

import it.unipol.crm.sinistro.DatabasePopulator;
import it.unipol.crm.sinistro.ModelPopulator;
import it.unipol.crm.sinistro.exception.WrongInputObjectException;
import it.unipol.crm.sinistro.model.contratto.ContrattoAssociato;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContract;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContractRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ContrattoServiceTest {

    @Autowired
    private ContrattoService service;

    @Autowired
    private UplCrmClaimContractRepository repository;

    @Autowired
    private DatabasePopulator databasePopulator;

    @Test
    void shouldAddContrattoAssociato() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        ContrattoAssociato contrattoAssociato = ModelPopulator.prepareContrattoAssociato();
        UplCrmClaimContract claimContract = ModelPopulator.prepareUplCrmClaimContract();

        // when
        final long countBefore = repository.count();
        final UplCrmClaimContract given = service.addContratto(contrattoAssociato, BigInteger.ONE, "uid=JUnit", "JU", "app=JUnit");
        final long countAfter = repository.count();

        // then
        assertNotNull(given);
        assertEquals(countBefore + 1, countAfter);
        assertNotNull(given.getContractId());
        assertEquals(claimContract.getClaimContrId(), given.getClaimContrId());
    }

    @Test
    void shouldThrowExceptionForAddContrattoWhenObjectIsNull() {

        // when
        assertThrows(WrongInputObjectException.class, () -> service.addContratto
                (null, BigInteger.ONE, "uid=JUnit", "JU", "app=JUnit"));
    }

    @Test
    void shouldThrowExceptionForAddContrattoWhenContrattoIdIsNull() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        ContrattoAssociato contrattoAssociato = ModelPopulator.prepareContrattoAssociato();
        contrattoAssociato.setContrattoId(null);

        // when
        assertThrows(WrongInputObjectException.class, () -> service.addContratto
                (contrattoAssociato, BigInteger.ONE, "uid=JUnit", "JU", "app=JUnit"));
    }

    @Test
    void shouldThrowExceptionForAddContrattoWhenContrattoIdIdNotExist() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        ContrattoAssociato contrattoAssociato = ModelPopulator.prepareContrattoAssociato();
        contrattoAssociato.setContrattoId(BigInteger.TEN);

        // when
        assertThrows(WrongInputObjectException.class, () -> service.addContratto
                (contrattoAssociato, BigInteger.ONE, "uid=JUnit", "JU", "app=JUnit"));
    }
}