package com.cfernandez.samplespringbootswaggerapi.application.exception;

/**
 *
 * @author carlos
 */
public class ControllerException extends RuntimeException {
    
    public ControllerException(Throwable cause, String message) {
        super(message, cause);
    }
    
    public ControllerException(String message){
        super(message);
    }
    
}
