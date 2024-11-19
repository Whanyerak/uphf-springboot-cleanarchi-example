package com.example.demo.infrastructure.adapter;

import com.example.demo.application.exception.PokemonNotFoundException;
import com.example.demo.domain.bean.Pokemon;
import com.example.demo.domain.port.PokemonPort;
import com.example.demo.infrastructure.dao.PokemonJpaDao;
import com.example.demo.infrastructure.dto.PokemonJpaDto;
import com.example.demo.infrastructure.mapper.DomainToInfrastructureMapper;
import com.example.demo.infrastructure.mapper.InfrastructureToDomainMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PokemonAdapter implements PokemonPort {
    
    private final PokemonJpaDao pokemonJpaDao;
    private final InfrastructureToDomainMapper toDomainMapper;
    private final DomainToInfrastructureMapper fromDomainMapper;

    public PokemonAdapter(PokemonJpaDao pokemonJpaDao, InfrastructureToDomainMapper toDomainMapper, DomainToInfrastructureMapper fromDomainMapper) {
        this.pokemonJpaDao = pokemonJpaDao;
        this.toDomainMapper = toDomainMapper;
        this.fromDomainMapper = fromDomainMapper;
    }
    
    public Pokemon findPokemonByName(String name) {
        Optional<PokemonJpaDto> pokemon = pokemonJpaDao.findPokemonByName(name);
        
        return pokemon.map(toDomainMapper::mapToPokemon)
                .orElseThrow(PokemonNotFoundException::new);
    }
    
    public void save(Pokemon pokemon) {
        pokemonJpaDao.save(fromDomainMapper.mapFromPokemon(pokemon));
    }
    
}
