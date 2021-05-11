package com.cfernandez.samplespringbootswaggerapi.adapter.web;

import com.cfernandez.samplespringbootswaggerapi.application.exception.ControllerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionControllerTest {

    @InjectMocks private ExceptionController exceptionController;

    @Mock private Throwable throwable;

    private static ControllerException CONTROLLER_EXCEPTION;
    private static final String MESSAGE = "test";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Exception controller with null cause")
    @Test
    void controllerExceptionNullCause(){
        CONTROLLER_EXCEPTION = new ControllerException(MESSAGE);

        final ResponseEntity<String> response = exceptionController.controllerException(CONTROLLER_EXCEPTION);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(MESSAGE, response.getBody());
    }

    @DisplayName("Exception controller with non null cause")
    @Test
    void controllerException(){
        CONTROLLER_EXCEPTION = new ControllerException(throwable, MESSAGE);

        final ResponseEntity<String> response = exceptionController.controllerException(CONTROLLER_EXCEPTION);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal server error", response.getBody());
    }
}