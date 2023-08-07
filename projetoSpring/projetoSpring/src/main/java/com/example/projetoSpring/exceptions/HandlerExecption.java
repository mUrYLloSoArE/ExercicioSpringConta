package com.example.projetoSpring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExecption extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ContaNotFoundException.class)
    public ResponseEntity<Object> contaNotFoundId(ContaNotFoundException conta, WebRequest request){

        return new ResponseEntity<>(new ApiError(conta.getMessage(),HttpStatus.NOT_FOUND,LocalDateTime.now()),HttpStatus.NOT_FOUND);

    }

}
