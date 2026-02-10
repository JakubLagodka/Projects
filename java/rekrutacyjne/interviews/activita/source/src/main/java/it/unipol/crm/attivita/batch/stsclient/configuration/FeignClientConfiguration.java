package it.unipol.crm.attivita.batch.stsclient.configuration;

import feign.Client;
import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignClientConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    private Client getClient() {
        // taken from: https://github.com/OpenFeign/feign/issues/525
        return new Client.Default(SSLSocketClient.getSSLSocketFactory(), SSLSocketClient.getHostnameVerifier());
    }
}
