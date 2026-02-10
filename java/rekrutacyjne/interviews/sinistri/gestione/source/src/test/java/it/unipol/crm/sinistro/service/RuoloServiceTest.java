package it.unipol.crm.sinistro.service;

import it.unipol.crm.sinistro.DatabasePopulator;
import it.unipol.crm.sinistro.ModelPopulator;
import it.unipol.crm.sinistro.exception.WrongInputObjectException;
import it.unipol.crm.sinistro.model.ruolo.RuoloSinistro;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRole;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RuoloServiceTest {

    @Autowired
    private RuoloService service;

    @Autowired
    private UplCrmClaimRoleRepository repository;

    @Autowired
    private DatabasePopulator databasePopulator;

    @Test
    void shouldAddRuolo() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        List<RuoloSinistro> ruoliSinistro = ModelPopulator.prepareRuoliSinistro();

        // when
        final long countBefore = repository.count();
        final UplCrmClaimRole given = service.addRuolo(ruoliSinistro.get(0), BigInteger.ONE, "uid=JUnit", "JU", "app=JUnit");
        final long countAfter = repository.count();

        // then
        assertNotNull(given);
        assertEquals(countBefore + 1, countAfter);
        assertNotNull(given.getContId());
        assertEquals(BigInteger.valueOf(6), given.getClaimRoleId());
    }

    @Test
    void shouldThrowExceptionForAddRuoloWhenObjectIsNull() {

        // when
        assertThrows(WrongInputObjectException.class, () -> service.addRuolo
                (null, BigInteger.ONE, "uid=JUnit", "JU", "app=JUnit"));
    }

    @Test
    void shouldThrowExceptionForAddRuoloWhenContattoIdIsNull() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        List<RuoloSinistro> ruoliSinistro = ModelPopulator.prepareRuoliSinistro();
        RuoloSinistro ruoloSinistro = ruoliSinistro.get(0);
        ruoloSinistro.setContattoId(null);

        // when
        assertThrows(WrongInputObjectException.class, () -> service.addRuolo
                (ruoloSinistro, BigInteger.ONE, "uid=JUnit", "JU", "app=JUnit"));
    }

    @Test
    void shouldThrowExceptionForAddRuoloWhenContattoIdIdNotExist() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        List<RuoloSinistro> ruoliSinistro = ModelPopulator.prepareRuoliSinistro();
        RuoloSinistro ruoloSinistro = ruoliSinistro.get(0);
        ruoloSinistro.setContattoId(BigInteger.TEN);

        // when
        assertThrows(WrongInputObjectException.class, () -> service.addRuolo
                (ruoloSinistro, BigInteger.ONE, "uid=JUnit", "JU", "app=JUnit"));
    }
}