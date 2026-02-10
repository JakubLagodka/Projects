package pl.lektury.hexagonal.application.service;

import org.springframework.stereotype.Service;
import pl.lektury.hexagonal.domain.exception.AuthorNotFoundException;
import pl.lektury.hexagonal.domain.model.Author;
import pl.lektury.hexagonal.domain.model.AuthorDetails;
import pl.lektury.hexagonal.domain.port.in.GetAuthorsUseCase;
import pl.lektury.hexagonal.domain.port.out.AuthorProvider;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorService implements GetAuthorsUseCase {

    private final AuthorProvider authorProvider;

    public AuthorService( AuthorProvider authorProvider ) {
        this.authorProvider = authorProvider;
    }

    @Override
    public List<Author> getAuthors( Optional<String> nameFilter ) {
        List<Author> authors = authorProvider.fetchAll();
        return nameFilter
                .map( filter -> authors.stream()
                        .filter( author -> author.name().toLowerCase().contains( filter.toLowerCase() ) )
                        .toList() )
                .orElse( authors );
    }

    @Override
    public AuthorDetails getAuthorDetails( String authorId ) {
        return authorProvider.fetchById( authorId )
                .orElseThrow( () -> new AuthorNotFoundException( "Author with id " + authorId + " not found" ) );
    }
}
