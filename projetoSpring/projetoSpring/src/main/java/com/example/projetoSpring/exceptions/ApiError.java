package com.example.projetoSpring.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiError{
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;

    public ApiError(String message, HttpStatus status, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }
}
