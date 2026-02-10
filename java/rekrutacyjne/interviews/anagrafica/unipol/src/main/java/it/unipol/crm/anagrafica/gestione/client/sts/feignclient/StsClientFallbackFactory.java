package it.unipol.crm.anagrafica.gestione.client.sts.feignclient;

import feign.FeignException;
import it.unipol.crm.anagrafica.gestione.client.sts.exception.StsFeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StsClientFallbackFactory implements FallbackFactory<StsClient> {

    @Override
    public StsClient create(Throwable throwable) {
        return value -> {

            if (throwable instanceof FeignException) {

                log.error("An feign exception occurred when calling the StsDevFeignClient.getToken method, preparing MyStsFeignException");

                throw new StsFeignException(throwable.getMessage(),
                        "temp value",
                        ((FeignException) throwable).status(),
                        throwable.getClass().getSimpleName(),
                        throwable.getMessage(),
                        ((FeignException) throwable).request().url());

            } else {

                log.error("Other kind of exception occurred when calling the StsDevFeignClient.getToken method, preparing MyStsFeignException");

                throw new StsFeignException(throwable.getMessage(),
                        "temp value",
                        null,
                        throwable.getClass().getSimpleName(),
                        throwable.getMessage(),
                        null);
            }

        };
    }
}
