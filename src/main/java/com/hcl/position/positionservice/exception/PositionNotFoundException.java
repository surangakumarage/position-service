package com.hcl.position.positionservice.exception;

public class PositionNotFoundException extends  PositionException{
    public PositionNotFoundException() {
        super("Requested entity not present in the DB." +  ErrorCode.POSITION_NOT_FOUND);
    }

    public PositionNotFoundException (String message) {
        super(message +  ErrorCode.POSITION_NOT_FOUND);
    }
}
