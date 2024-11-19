package com.example.demo.application.exception;

public class PokemonNotFoundException extends InfrastructureException {
    
    public PokemonNotFoundException() {
        super("Pokemon not found in database.");
    }
    
}
