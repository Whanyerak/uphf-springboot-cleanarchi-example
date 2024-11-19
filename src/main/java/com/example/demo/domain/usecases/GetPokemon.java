package com.example.demo.domain.usecases;

import com.example.demo.application.exception.PokemonNotFoundException;
import com.example.demo.domain.bean.Pokemon;
import com.example.demo.domain.port.PokemonPort;
import com.example.demo.infrastructure.adapter.PokemonAdapter;
import org.springframework.stereotype.Component;

@Component
public class GetPokemon {
    
    private final PokemonPort pokemonPort;

    public GetPokemon(PokemonAdapter pokemonPort) {
        this.pokemonPort = pokemonPort;
    }

    public Pokemon execute(String name) throws PokemonNotFoundException {
        return pokemonPort.findPokemonByName(name);
    }
    
}
