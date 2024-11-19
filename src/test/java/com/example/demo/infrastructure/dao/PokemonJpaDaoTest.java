package com.example.demo.infrastructure.dao;

import com.example.demo.infrastructure.dto.PokemonJpaDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PokemonJpaDaoTest {
    
    @Autowired
    private PokemonJpaDao pokemonJpaDao;
    
    @Test
    void shouldSavePokemon() {
        // Arrange
        PokemonJpaDto pokemonJpaDto = new PokemonJpaDto("pokemon-name");

        // Act
        pokemonJpaDao.save(pokemonJpaDto);
        
        // Assert
        List<PokemonJpaDto> existingPokemonJpaDtos = pokemonJpaDao.findAll();

        PokemonJpaDto expectedPokemonJpaDto = new PokemonJpaDto(1L, "pokemon-name");
        assertThat(existingPokemonJpaDtos).containsExactly(expectedPokemonJpaDto);
    }

}