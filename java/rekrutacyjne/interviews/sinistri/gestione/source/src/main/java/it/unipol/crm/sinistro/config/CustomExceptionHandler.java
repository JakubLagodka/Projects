package it.unipol.crm.sinistro.config;

import it.unipol.crm.sinistro.exception.WrongInputObjectException;
import it.unipol.crm.sinistro.model.ErroreRisp;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErroreRisp> handleWrongInputObjectException(WrongInputObjectException exception) {

        log.error("WrongInputObjectException occurred! Request id: {}", exception.getRequestId(), exception);

        final var erroreRisp = new ErroreRisp();
        erroreRisp.setMessaggioErrore(exception.getMessage());

        return new ResponseEntity<>(erroreRisp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErroreRisp> handleResponseStatusException(ResponseStatusException exception) {

        log.error("ResponseStatusException occurred! Http Status: {}", exception.getStatus(), exception);

        final var erroreRisp = new ErroreRisp();
        erroreRisp.setMessaggioErrore(exception.getReason());

        return new ResponseEntity<>(erroreRisp, exception.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErroreRisp> handleIllegalArgumentException(IllegalArgumentException exception) {

        log.error("IllegalArgumentException occurred!", exception);

        final var erroreRisp = new ErroreRisp();
        erroreRisp.setMessaggioErrore(exception.getMessage());

        return new ResponseEntity<>(erroreRisp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErroreRisp> handleConnectionException(JDBCConnectionException exception) {

        log.error("JDBCConnectionException occurred!", exception);

        final var erroreRisp = new ErroreRisp();
        erroreRisp.setMessaggioErrore(exception.getMessage());

        return new ResponseEntity<>(erroreRisp, HttpStatus.SERVICE_UNAVAILABLE);
    }
}