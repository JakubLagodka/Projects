package pl.lagodka.currency;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    NotFoundException(String msg){
        super("Waluta o kodzie " + msg + " nie istnieje");
    }
}
