package pl.lektury.hexagonal.infrastructure.adapter.in;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.lektury.hexagonal.domain.exception.AuthorNotFoundException;
import pl.lektury.hexagonal.infrastructure.adapter.out.dto.ErrorResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler( AuthorNotFoundException.class  )
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public ErrorResponse handleAuthorNotFoundException( AuthorNotFoundException exception ) {
        logger.warn("Resource not found: {}", exception.getMessage());
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now());
    }

    @ExceptionHandler( Exception.class  )
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGeneralException( Exception exception ) {
        logger.warn("Unexpected error occured", exception);
        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),
                LocalDateTime.now());
    }
}
