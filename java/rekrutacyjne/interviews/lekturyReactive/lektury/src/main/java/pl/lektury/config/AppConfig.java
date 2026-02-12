package pl.lektury.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import pl.lektury.config.settings.AppSettings;
import pl.lektury.service.AuthorInformationService;
import pl.lektury.service.WLAuthorInformationService;
import reactor.util.retry.Retry;

import java.time.Duration;

@Configuration
public class AppConfig {

    @Bean("client-wl")
    public WebClient webClient( AppSettings appSettings) {
        return WebClient.builder()
                .baseUrl( appSettings.url() )
                .build();
    }

    @Bean("author-information-client-wl")
    public AuthorInformationService authorInformationClientWL( @Qualifier("client-wl") WebClient webClientWL ) {
        return WLAuthorInformationService.of( webClientWL, WLAuthorInformationService.Config.of( Retry.backoff( 3, Duration.ofMillis( 500 ) )
                .filter( throwable -> !(throwable instanceof WebClientResponseException exception && exception.getStatusCode().is4xxClientError() ) ),
                Duration.ofSeconds( 2 ),
                CircuitBreaker.ofDefaults( "WLAthorInformationClientReactive" )) )      ;
    }
}
