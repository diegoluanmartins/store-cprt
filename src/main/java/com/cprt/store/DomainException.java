package com.cprt.store;

public class DomainException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DomainException(String message){
        super(message);
    }

}
