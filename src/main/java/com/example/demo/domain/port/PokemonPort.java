package com.example.demo.domain.port;

import com.example.demo.domain.bean.Pokemon;

public interface PokemonPort {

    Pokemon findPokemonByName(String name);

    void save(Pokemon pokemon);
    
}
