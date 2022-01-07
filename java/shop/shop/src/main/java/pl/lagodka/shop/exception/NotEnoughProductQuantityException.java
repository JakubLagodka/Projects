package pl.lagodka.shop.exception;

public class NotEnoughProductQuantityException extends RuntimeException{
    public NotEnoughProductQuantityException(String message) {
        super(message);
    }
}
