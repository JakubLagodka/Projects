package pl.lektury.hexagonal.domain.exception;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException( String s ) {
        super(s);
    }
}
