package pl.lagodka.shop.cotroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.lagodka.shop.exception.NotEnoughProductQuantityException;
import pl.lagodka.shop.model.dto.FieldErrorDto;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class AdviceController {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEntityNotFoundException(EntityNotFoundException e) {
        log.error("Not found", e);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error("Not unique data", e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<FieldErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("", e);
        return e.getBindingResult().getAllErrors().stream()
                .map(objectError -> {
                    FieldError fieldError = (FieldError) objectError;
                    return new FieldErrorDto(fieldError.getField(), fieldError.getDefaultMessage());

                })
                .collect(Collectors.toList());
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        log.error("Not found", e);
    }

    @ExceptionHandler(NotEnoughProductQuantityException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleNotEnoughProductQuantityException(NotEnoughProductQuantityException e) {
        log.error("Requested products are not available in given quantity", e);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleConstraintViolationException(ConstraintViolationException e) {
        log.error(e.getMessage(), e);
    }

    @ExceptionHandler(AuthenticationServiceException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleAuthenticationServiceException(AuthenticationServiceException e) {
        log.error(e.getMessage(), e);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleBadCredentialsException(BadCredentialsException e) {
        log.error(e.getMessage(), e);
    }

}
