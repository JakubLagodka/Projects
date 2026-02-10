package it.unipol.crm.sinistro.service;

import it.unipol.crm.sinistro.DatabasePopulator;
import it.unipol.crm.sinistro.ModelPopulator;
import it.unipol.crm.sinistro.exception.WrongInputObjectException;
import it.unipol.crm.sinistro.model.sinistro.Sinistro;
import it.unipol.crm.sinistro.model.sinistro.SinistroPaginatoRisp;
import it.unipol.crm.sinistro.model.sinistro.SinistroRisp;
import it.unipol.crm.sinistro.persistence.entity.claim.UplCrmClaimRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SinistroServiceTest {

    @Autowired
    private SinistroService service;

    @Autowired
    private UplCrmClaimRepository repository;

    @Autowired
    private DatabasePopulator databasePopulator;

    @Test
    void shouldGetSinistro() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        SinistroRisp expected = ModelPopulator.prepareSinistroRisp();

        // when
        final SinistroRisp given = service.getSinistro(BigInteger.ONE);

        // then
        assertNotNull(given);
        assertEquals(expected.getImporto(), given.getImporto());
        assertEquals(expected, given);
    }

    @Test
    void shouldThrowExceptionBadRequestForGetSinistroWhenIdIsNull() {

        // then
        ResponseStatusException thrown = assertThrows(ResponseStatusException.class, () -> service.getSinistro(null));
        assertEquals(HttpStatus.BAD_REQUEST, thrown.getStatus());
    }

    @Test
    void shouldThrowExceptionNotFoundForGetSinistroWhenIdNotExist() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        // then
        ResponseStatusException thrown = assertThrows(ResponseStatusException.class, () -> service.getSinistro(BigInteger.TEN));
        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatus());
    }

    @Test
    void shouldGetSinistri() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        SinistroPaginatoRisp expected = ModelPopulator.prepareSinistroPaginatoRisp();

        // when
        final SinistroPaginatoRisp given = service.getSinistri(BigInteger.ONE, 0, 10,
                LocalDate.of(2019,10,10), LocalDate.of(2022,12,31),
                "120180890000419014", BigInteger.ONE);

        // then
        assertNotNull(given);
        assertEquals(expected, given);
    }

    @Test
    void shouldGetDefaultSinistri() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();
        SinistroPaginatoRisp expected = ModelPopulator.prepareSinistroPaginatoRisp();
        expected.getPaginazione().setRisultatiPerPagina(20);

        // when
        final SinistroPaginatoRisp given = service.getSinistri(BigInteger.ONE, null, null, null, null, null, null);

        // then
        assertNotNull(given);
        assertEquals(expected, given);
    }

    @Test
    void shouldThrowExceptionBadRequestForGetSinistriWhenContattoIdIsNull() {

        // then
        ResponseStatusException thrown = assertThrows(ResponseStatusException.class, () -> service.getSinistri(null, null, null, null, null, null, null));
        assertEquals(HttpStatus.BAD_REQUEST, thrown.getStatus());
    }


    @Test
    void shouldThrowExceptionNotFoundForGetSinistriIsEmpty() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        // then
        ResponseStatusException thrown = assertThrows(ResponseStatusException.class, () -> service.getSinistri(BigInteger.TEN, null, null, null, null, null, null));
        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatus());
    }

    @Test
    void shouldAddSinistro() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        SinistroRisp expected = ModelPopulator.prepareSinistroRisp();
        Sinistro sinistro = ModelPopulator.prepareSinistro();

        // when
        final long countBefore = repository.count();
        final SinistroRisp given = service.addSinistro(sinistro, "uid=JUnit", "JU", "app=JUnit");
        final long countAfter = repository.count();
        expected.setDataUltimoAggiornamento(given.getDataUltimoAggiornamento());
        expected.setId(BigInteger.valueOf(6));

        // then
        assertNotNull(given);
        assertEquals(countBefore + 1, countAfter);
        assertNotNull(given.getRamo());
        assertEquals(expected, given);
    }

    @Test
    void shouldAddMinimalSinistro() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        SinistroRisp expected = new SinistroRisp();
        expected.setRamo(BigInteger.valueOf(22));
        expected.setId(BigInteger.valueOf(6));
        Sinistro sinistro = new Sinistro();
        sinistro.setRamo(BigInteger.valueOf(22));

        // when
        final long countBefore = repository.count();
        final SinistroRisp given = service.addSinistro(sinistro, "uid=JUnit", "JU", "app=JUnit");
        final long countAfter = repository.count();
        expected.setDataUltimoAggiornamento(given.getDataUltimoAggiornamento());

        // then
        assertNotNull(given);
        assertEquals(countBefore + 1, countAfter);
        assertNotNull(given.getRamo());
        assertEquals(expected, given);
    }

    @Test
    void shouldThrowExceptionForAddSinistroWhenObjectIsNull() {

        // when
        assertThrows(WrongInputObjectException.class, () -> service.addSinistro
                (null, "uid=JUnit", "JU", "app=JUnit"));
    }

    @Test
    void shouldThrowExceptionForAddSinistroWhenRamoIsNull() {

        // given
        databasePopulator.populateSinistroDatabaseBeforeTestsInClass();

        Sinistro sinistro = ModelPopulator.prepareSinistro();
        sinistro.setRamo(null);

        // when
        assertThrows(WrongInputObjectException.class, () -> service.addSinistro
                (sinistro, "uid=JUnit", "JU", "app=JUnit"));
    }
}