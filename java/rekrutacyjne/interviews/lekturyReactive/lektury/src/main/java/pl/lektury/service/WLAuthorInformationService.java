package pl.lektury.service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import pl.lektury.model.Author;
import pl.lektury.model.AuthorDTO;
import pl.lektury.model.AuthorDetails;
import pl.lektury.model.AuthorDetailsDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;

@RequiredArgsConstructor(staticName = "of")
public class WLAuthorInformationService implements AuthorInformationService {

    public record Config(Retry retrySpec, Duration timeout, CircuitBreaker circuitBreaker) {

        public static Config of(Retry retrySpec, Duration timeout, CircuitBreaker circuitBreaker){
            return new Config(retrySpec, timeout, circuitBreaker);
        }
    }

    private final WebClient webClient;
    private final Config config;

    @Override
    public Flux<Author> findAll( String nameMather ) {
        String nameMatcherLowerCase = nameMather != null
        ? nameMather.toLowerCase()
                : null;
        Function<AuthorDTO, Author> toAuthor = authorDTO -> Author.of( authorDTO.slug(), authorDTO.name() );

        Predicate<AuthorDTO> byName = authorDTO -> Strings.isBlank(nameMatcherLowerCase) ||
                authorDTO.name().toLowerCase( Locale.getDefault()).contains(nameMatcherLowerCase);
        return webClient.get().uri( "/authors/" )
                .accept( MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux( AuthorDTO.class )
                .timeout( config.timeout )
                .retryWhen( config.retrySpec )
                .transform( CircuitBreakerOperator.of( config.circuitBreaker ) )
                .filter( byName )
                .map( toAuthor );
    }

    @Override
    public Mono<AuthorDetails> findById( String id ) {
        Function<AuthorDetailsDTO, AuthorDetails> toAuthorDetails = authorDTO -> AuthorDetails.of( id,authorDTO.name(), authorDTO.name() );

        return webClient.get()
                .uri( "/authors/{id}" )
                .accept( MediaType.APPLICATION_JSON )
                .retrieve()
                .bodyToMono( AuthorDetailsDTO.class )
                .timeout( config.timeout )
                .retryWhen( config.retrySpec )
                .transform( CircuitBreakerOperator.of( config.circuitBreaker ) )
                .map( toAuthorDetails );
    }
}
