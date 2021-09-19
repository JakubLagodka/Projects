package pl.polsl.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CodeAlreadyUsedException extends RuntimeException {

    public CodeAlreadyUsedException(String code) {
        super("Code '" + code + "' already used");
    }

}
