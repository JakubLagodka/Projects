package it.unipol.crm.anagrafica.gestione.client.sts.feignclient;

import feign.FeignException;
import feign.Request;
import it.unipol.crm.anagrafica.gestione.client.sts.exception.StsFeignException;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StsClientFallbackFactoryTest {

    @Test
    void shouldThrowMyStsFeignExceptionOnFeignException(){
        val factory = new StsClientFallbackFactory();
        val fixture = factory.create(new FeignException.BadRequest("Internal error", Request.create("GET", "testUrl", new HashMap<>(), null, StandardCharsets.UTF_8), null, null));

        assertThrows(StsFeignException.class, () -> fixture.getToken(null));
    }

    @Test
    void shouldThrowMyStsFeignExceptionOnOtherException(){
        val factory = new StsClientFallbackFactory();
        val fixture = factory.create(new RuntimeException());

        assertThrows(StsFeignException.class, () -> fixture.getToken(null));
    }

}