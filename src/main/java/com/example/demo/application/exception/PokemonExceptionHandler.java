package com.example.demo.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class PokemonExceptionHandler {
    
    @ExceptionHandler(InfrastructureException.class)
    public ResponseEntity<String> manageInfrastructureException(InfrastructureException exception) {
        if (exception instanceof PokemonNotFoundException) {
            log.warn(exception.getMessage());
            
            return ResponseEntity.notFound().build();
        }
        
        log.error(exception.getMessage());
        return ResponseEntity.internalServerError().build();
    }
    
}
