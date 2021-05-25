package com.cfernandez.samplespringbootswaggerapi.application.exception;

/**
 *
 * @author carlos
 */
public class ControllerException extends RuntimeException {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerException(Throwable cause, String message) {
        super(message, cause);
    }
    
    public ControllerException(String message){
        super(message);
    }
    
}
