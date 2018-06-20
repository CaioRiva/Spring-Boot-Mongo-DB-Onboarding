package com.criva.onboardingproject.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class GeneralRequestError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;

    private GeneralRequestError() {

        timestamp = LocalDateTime.now();
    }

    public GeneralRequestError(HttpStatus status) {

        this();
        this.status = status;
        this.message = "Unexpected Error";
    }

    public GeneralRequestError(HttpStatus status, String message) {

        this();
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
