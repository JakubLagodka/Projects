package it.unipol.crm.anagrafica.gestione.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static it.unipol.crm.anagrafica.gestione.util.Utils.generateNewId;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Utils.class)
class UtilsTest {

    @Test
    void shouldBeAbleToGenerateUniqueIds() {
        // given
        BigInteger newId1 = generateNewId();
        BigInteger newId2 = generateNewId();
        // then
        assertNotNull(newId1);
        assertNotNull(newId2);
        assertNotEquals(newId1, newId2);
    }

}