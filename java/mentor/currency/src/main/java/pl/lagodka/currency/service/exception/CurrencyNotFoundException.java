package pl.lagodka.currency.service.exception;

public class CurrencyNotFoundException  extends RuntimeException{

    public static final long serialVersionUID = 1236996191743114729L;

    public CurrencyNotFoundException(String code){
        super(String.format("code: %s is not available", code));
    }
}
