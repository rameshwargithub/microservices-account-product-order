package com.example.product_service.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex){
        return ResponseEntity.badRequest().body(ex.getBindingResult().getFieldErrors().stream().findFirst().map(err-> Map.of("message",err.getDefaultMessage())).orElse(Map.of("message","invalid input")));
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> noSuchElementException(MethodArgumentNotValidException ex){
        return ResponseEntity.internalServerError().body(ex.getBindingResult().getFieldErrors().stream().findFirst().map(err-> Map.of("message",err.getDefaultMessage())).orElse(Map.of("message","value not found")));
    }
}
