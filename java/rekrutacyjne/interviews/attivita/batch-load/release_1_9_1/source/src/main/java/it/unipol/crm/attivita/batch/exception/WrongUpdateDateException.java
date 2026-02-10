package it.unipol.crm.attivita.batch.exception;

public class WrongUpdateDateException extends RuntimeException{

    public WrongUpdateDateException(String message) {
        super(message);
    }
}