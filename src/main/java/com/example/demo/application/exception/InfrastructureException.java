package com.example.demo.application.exception;

import lombok.Setter;

@Setter
public class InfrastructureException extends RuntimeException {
    
    private String message;

    public InfrastructureException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
