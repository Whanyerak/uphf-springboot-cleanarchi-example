package com.example.demo.application.mapper;

import com.example.demo.application.dto.PokemonJsonDto;
import com.example.demo.domain.bean.Pokemon;
import org.springframework.stereotype.Component;

@Component
public class DomainToApplicationMapper {
    
    public PokemonJsonDto mapFromPokemon(Pokemon pokemon) {
        return new PokemonJsonDto(pokemon.getName());
    }
    
}
