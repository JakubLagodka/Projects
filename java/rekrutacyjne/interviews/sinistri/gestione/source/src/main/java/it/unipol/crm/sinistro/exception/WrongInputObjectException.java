package it.unipol.crm.sinistro.exception;

import lombok.Getter;

@Getter
public class WrongInputObjectException extends RuntimeException {

    private final String requestId;

    public WrongInputObjectException(String message, String requestId) {

        super(message);
        this.requestId = requestId;
    }
}