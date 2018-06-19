package com.criva.onboardingproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFoundExceptionHandler(EntityNotFoundException e) {

        return response(HttpStatus.NOT_FOUND, e.getMessage());
    }

    private ResponseEntity<GeneralRequestError> response(HttpStatus status, String message) {

        return new ResponseEntity<>(new GeneralRequestError(status.value(), message), status);
    }
}
