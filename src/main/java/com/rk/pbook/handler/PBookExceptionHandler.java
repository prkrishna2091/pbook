package com.rk.pbook.handler;

import com.rk.pbook.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PBookExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundException> handleResourceNotFoundException(ResourceNotFoundException exception){
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
