package com.example.demo.application.mapper;

import com.example.demo.application.dto.PokemonJsonDto;
import com.example.demo.domain.bean.Pokemon;
import org.springframework.stereotype.Component;

@Component
public class ApplicationToDomainMapper {
    
    public Pokemon mapToPokemon(PokemonJsonDto pokemonJsonDto) {
        return new Pokemon(pokemonJsonDto.name());
    }
    
}
