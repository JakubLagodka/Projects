package it.unipol.crm.anagrafica.gestione.client.sts.feignclient;

import feign.Headers;
import it.unipol.crm.anagrafica.gestione.client.sts.configuration.FeignClientConfiguration;
import it.unipol.crm.anagrafica.gestione.client.sts.model.StsRequest;
import it.unipol.crm.anagrafica.gestione.client.sts.model.StsResponse;
import it.unipol.crm.logger.gestione.aspect.NoAspectLogging;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name="stsDevFeignClient",
        url = "${STS_URL}",
        path = "${STS_PATH}",
        configuration = FeignClientConfiguration.class,
        fallbackFactory = StsClientFallbackFactory.class)
public interface StsClient {

    @PostMapping
    @Headers("Content-Type: " + MediaType.APPLICATION_JSON_VALUE)
    @NoAspectLogging
    StsResponse getToken(@RequestBody StsRequest value);
}
