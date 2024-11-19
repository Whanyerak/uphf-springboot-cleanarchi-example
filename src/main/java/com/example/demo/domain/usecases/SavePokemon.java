package com.example.demo.domain.usecases;

import com.example.demo.domain.bean.Pokemon;
import com.example.demo.domain.port.PokemonPort;
import com.example.demo.infrastructure.adapter.PokemonAdapter;
import org.springframework.stereotype.Component;

@Component
public class SavePokemon {

    private final PokemonPort pokemonPort;

    public SavePokemon(PokemonAdapter pokemonAdapter) {
        this.pokemonPort = pokemonAdapter;
    }

    public void execute(Pokemon pokemon) {
        pokemonPort.save(pokemon);
    }
    
}
