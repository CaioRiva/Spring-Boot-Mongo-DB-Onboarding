package com.criva.onboardingproject.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class GeneralRequestError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Getter
    private LocalDateTime timestamp;

    @Getter
    private HttpStatus status;

    @Getter
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
}
