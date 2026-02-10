package it.unipol.crm.attivita.batch.stsclient.service;

import it.unipol.crm.attivita.batch.stsclient.feignclient.StsClient;
import it.unipol.crm.attivita.batch.stsclient.model.StsRequest;
import it.unipol.crm.attivita.batch.stsclient.model.StsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class StsTokenService {

    @Autowired
    private StsRequest stsRequest;

    @Autowired
    private StsClient stsClient;

    @Cacheable(value = "jwtTokens", sync = true)
    public synchronized StsResponse getToken(String stsToken) throws RuntimeException {

        stsRequest.setToken(stsToken);
        return stsClient.getToken(stsRequest);
    }

    @CacheEvict(value = "jwtTokens", allEntries = true)
    @Scheduled(fixedRateString = "${TOKEN_CACHE_TTL}", timeUnit = TimeUnit.MINUTES)
    public void emptyTokensCache() {
        log.info("emptying jwt Tokens cache");
    }
}
