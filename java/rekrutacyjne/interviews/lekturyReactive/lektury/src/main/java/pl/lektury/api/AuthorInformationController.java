package pl.lektury.reactive.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.lektury.reactive.model.Author;
import pl.lektury.reactive.service.AuthorInformationService;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorInformationController {

    @Qualifier("author-information-client-wl")
    private final AuthorInformationService authorInformationService;

    @GetMapping(value = {"","/"})
    public Flux<Author> getAuthors( @RequestParam(required = false) String nameContains ){

    }
}
