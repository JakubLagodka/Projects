package pl.lagodka.currency.service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.lagodka.currency.service.error.CurrencyApiError;


@ControllerAdvice
public class CurrencyRestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyRestExceptionHandler.class);

    @ExceptionHandler({CurrencyNotFoundException.class})
    public ResponseEntity<CurrencyApiError> handleCurrencyNotFoundException(CurrencyNotFoundException ex) {
        String message = ex.getMessage();
        logger.error("ErrorMessage: {} , exceptionBody: {}", message, ex);
        final CurrencyApiError currencyApiError = new CurrencyApiError(HttpStatus.BAD_REQUEST, message, ex);
        return new ResponseEntity<>(currencyApiError, currencyApiError.getStatus());
    }
}
