package com.cfernandez.samplespringbootswaggerapi.application.exception;

/**
 *
 * @author carlos
 */
public class ServiceException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
        super(message);
    }
    
}
