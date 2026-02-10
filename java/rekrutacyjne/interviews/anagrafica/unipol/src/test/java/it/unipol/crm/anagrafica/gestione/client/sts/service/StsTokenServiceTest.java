package it.unipol.crm.anagrafica.gestione.client.sts.service;

import it.unipol.crm.anagrafica.gestione.client.sts.feignclient.StsClient;
import it.unipol.crm.anagrafica.gestione.client.sts.model.StsRequest;
import it.unipol.crm.anagrafica.gestione.client.sts.model.StsResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
class StsTokenServiceTest {

    @Mock
    private StsClient stsClient;

    @Mock
    private StsRequest request;

    @InjectMocks
    private StsTokenService service;

    @BeforeEach
    public void setup(){
        Mockito.reset(stsClient);
    }

    @Test
    void testGetToken(){

        // given
        BDDMockito.given(stsClient.getToken(any())).willReturn(new StsResponse());

        // when
        final String token = service.getToken("VVQtQ1NMQTpTVCZQTGZlcGhkYXc3MQ==");

        // then
        Assertions.assertNotNull(token);
        Mockito.verify(stsClient, times(1)).getToken(ArgumentMatchers.any());
        log.info("STS token object: {}", token);
    }

}