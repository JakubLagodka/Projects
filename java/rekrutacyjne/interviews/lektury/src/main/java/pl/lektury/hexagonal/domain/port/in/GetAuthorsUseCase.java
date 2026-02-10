package pl.lektury.hexagonal.domain.port.in;

import pl.lektury.hexagonal.domain.model.Author;
import pl.lektury.hexagonal.domain.model.AuthorDetails;

import java.util.List;
import java.util.Optional;

public interface GetAuthorsUseCase {
    List<Author> getAuthors( Optional<String> nameFilter);
    AuthorDetails getAuthorDetails( String authorId);
}
