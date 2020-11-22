package pl.polsl.hotel.exceptions;

public abstract class BaseException extends RuntimeException {

    protected BaseException(String message) {
        super(message);
    }

}
