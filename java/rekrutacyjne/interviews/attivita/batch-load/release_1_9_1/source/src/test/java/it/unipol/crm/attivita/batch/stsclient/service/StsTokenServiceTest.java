package it.unipol.crm.attivita.batch.stsclient.service;

import it.unipol.crm.attivita.batch.stsclient.feignclient.StsClient;
import it.unipol.crm.attivita.batch.stsclient.model.StsResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StsTokenServiceTest {

    @SpyBean
    private StsClient stsClient;

    @Autowired
    @InjectMocks
    private StsTokenService service;

    @Before
    public void setup(){
        Mockito.reset(stsClient);
    }

    @Test
    public void testGetTokenWithCaching() throws Throwable {

        // given

        // when
        service.getToken("VVRBMDAyOTU6VE9LOTVEUkE=");
        final StsResponse token = service.getToken("VVRBMDAyOTU6VE9LOTVEUkE=");

        // then
        Assert.assertNotNull(token);
        Mockito.verify(stsClient, times(1)).getToken(any());
        log.info("STS token object: {}", token);
    }

}