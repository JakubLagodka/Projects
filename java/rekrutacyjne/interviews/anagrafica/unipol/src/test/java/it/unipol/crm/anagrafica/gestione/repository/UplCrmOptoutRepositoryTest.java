package it.unipol.crm.anagrafica.gestione.repository;


import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.config.DatabasePopulator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
public class UplCrmOptoutRepositoryTest {
	@Autowired
	private UplCrmOptoutRepository repository;

	@Autowired
	private DatabasePopulator databasePopulator;

	@Test
	void shouldGetUplCrmOptout() {
		//given
		databasePopulator.populateAnagraficaDatabaseBeforeTestsInClass();
		var id = BigInteger.valueOf(1);

		//when
		var actual = repository.findById(id);

		//then
		assertTrue(actual.isPresent(), "Should find one.");
	}
}
