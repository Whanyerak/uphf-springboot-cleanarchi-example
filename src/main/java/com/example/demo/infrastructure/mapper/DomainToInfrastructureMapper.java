package com.example.demo.infrastructure.mapper;

import com.example.demo.domain.bean.Pokemon;
import com.example.demo.infrastructure.dto.PokemonJpaDto;
import org.springframework.stereotype.Component;

@Component
public class DomainToInfrastructureMapper {
    
    public PokemonJpaDto mapFromPokemon(Pokemon pokemon) {
        return new PokemonJpaDto(pokemon.getName());
    }
        
}
