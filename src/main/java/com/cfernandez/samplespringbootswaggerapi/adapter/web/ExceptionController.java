package com.cfernandez.samplespringbootswaggerapi.adapter.web;

import com.cfernandez.samplespringbootswaggerapi.application.exception.ControllerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity<String> controllerException(ControllerException controllerException){
        if (controllerException.getCause() == null){
            return ResponseEntity.badRequest().body(controllerException.getMessage());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

}
