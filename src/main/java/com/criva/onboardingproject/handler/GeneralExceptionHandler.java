package com.criva.onboardingproject.handler;

import com.criva.onboardingproject.handler.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.PersistenceException;


@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<?> persistenceExceptionHandler(PersistenceException exception) {

        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, exception, "Database Access Error");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundExceptionHandler(UserNotFoundException exception) {

        return handleException(HttpStatus.NOT_FOUND, exception, "User Not Found");
    }

    private ResponseEntity<GeneralRequestError> handleException(HttpStatus status, RuntimeException exception, String message) {

        System.err.println(message);
        exception.printStackTrace();

        return new ResponseEntity<>(new GeneralRequestError(status, message), status);
    }
}
