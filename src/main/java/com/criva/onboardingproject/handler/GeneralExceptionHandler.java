package com.criva.onboardingproject.handler;

import com.criva.onboardingproject.handler.exception.room.RoomNotFoundException;
import com.criva.onboardingproject.handler.exception.user.UserNameAlreadyTakenException;
import com.criva.onboardingproject.handler.exception.user.UserNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.mongodb.MongoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;


@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(MongoException.class)
    public ResponseEntity<?> persistenceExceptionHandler(MongoException exception) {

        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, exception, "Database Access Error");
    }

    @ExceptionHandler(value = {InvalidDefinitionException.class, MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(Exception exception) {

        return handleException(HttpStatus.BAD_REQUEST, exception, "Invalid Arguments Error");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundExceptionHandler(UserNotFoundException exception) {

        return handleException(HttpStatus.NOT_FOUND, exception, "User Not Found");
    }

    @ExceptionHandler(UserNameAlreadyTakenException.class)
    public ResponseEntity<?> userNameAlreadyTakenExceptionHandler(UserNameAlreadyTakenException exception) {

        return handleException(HttpStatus.BAD_REQUEST, exception, "User's Name Already Taken");
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<?> roomNotFoundException(RoomNotFoundException exception) {

        return handleException(HttpStatus.BAD_REQUEST, exception, "Room Not Found");
    }

    private ResponseEntity<GeneralRequestError> handleException(HttpStatus status, Exception exception, String message) {

        System.err.println(message);
        exception.printStackTrace();

        return new ResponseEntity<>(new GeneralRequestError(status, message), status);
    }
}
