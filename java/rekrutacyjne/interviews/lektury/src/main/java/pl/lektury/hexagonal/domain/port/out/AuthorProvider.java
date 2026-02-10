package pl.lektury.hexagonal.domain.port.out;

import pl.lektury.hexagonal.domain.model.Author;
import pl.lektury.hexagonal.domain.model.AuthorDetails;

import java.util.List;
import java.util.Optional;

public interface AuthorProvider {
    List<Author> fetchAll();
    Optional<AuthorDetails> fetchById( String authorId);
}
