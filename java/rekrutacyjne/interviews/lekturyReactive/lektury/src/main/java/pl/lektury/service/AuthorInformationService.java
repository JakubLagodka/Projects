package pl.lektury.service;

import pl.lektury.model.Author;
import pl.lektury.model.AuthorDetails;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthorInformationService {
    Flux<Author> findAll(String nameMather);
    Mono<AuthorDetails> findById( String id);
}
