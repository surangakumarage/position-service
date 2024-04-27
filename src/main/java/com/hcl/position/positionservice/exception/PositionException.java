package com.hcl.position.positionservice.exception;

public class PositionException extends RuntimeException {

    private String code;
    private String message;

    public PositionException(String message) {
        super( message);
    }
}