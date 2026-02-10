package pl.lektury.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.lektury.model.Author;
import pl.lektury.model.AuthorDetails;
import pl.lektury.service.AuthorInformationService;
import reactor.core.publisher.Flux;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorInformationController {

    @Qualifier("author-information-client-wl")
    private final AuthorInformationService authorInformationService;

    @GetMapping(value = {"","/"})
    public Flux<Author> getAuthors( @RequestParam(required = false) String nameContains ){
        return authorInformationService.findAll(nameContains)
                .onErrorResume( WebClientResponseException.class,  e -> Mono.error( new ResponseStatusException( HttpStatus.BAD_GATEWAY, "Downstream service error" ) ) );
    }

    @GetMapping({"/{id}","/{id}/"})
    public Mono<AuthorDetails> getAuthorById( @PathVariable String id ){
        return authorInformationService.findById(id)
                .onErrorResume( WebClientResponseException.NotFound.class,  e -> Mono.error( new ResponseStatusException( HttpStatus.NOT_FOUND, "Author not found" ) ) )
                .onErrorResume( WebClientResponseException.class,  e -> Mono.error( new ResponseStatusException( HttpStatus.BAD_GATEWAY, "Downstream service error" )) );
    }
}
