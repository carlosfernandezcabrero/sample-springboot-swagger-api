package com.cfernandez.samplespringbootswaggerapi.application.exception;

/**
 *
 * @author carlos
 */
public class ServiceException extends Exception {
    
    public ServiceException(String message) {
        super(message);
    }
    
}
