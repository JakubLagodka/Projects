package it.unipol.crm.anagrafica.gestione.client.sts.service;

import it.unipol.crm.anagrafica.gestione.client.sts.feignclient.StsClient;
import it.unipol.crm.anagrafica.gestione.client.sts.model.StsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class StsTokenService {

    @Autowired
    private StsRequest stsRequest;

    @Autowired
    private StsClient stsClient;

    @Cacheable(value = "jwtTokens", sync = true)
    public synchronized String getToken(String token) throws RuntimeException {

        stsRequest.setToken(token);
        return "Bearer " + stsClient.getToken(stsRequest).getToken();
    }

    @CacheEvict(value = "jwtTokens", allEntries = true)
    @Scheduled(fixedRateString = "${TOKEN_CACHE_TTL}", timeUnit = TimeUnit.MINUTES)
    public void emptyTokensCache() {
        log.debug("Emptying jwt Tokens cache");
    }

}
