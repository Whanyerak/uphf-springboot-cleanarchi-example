package com.example.demo.application.contoller;

import com.example.demo.testutiles.PokemonJpaTestDao;
import com.example.demo.application.dto.PokemonJsonDto;
import com.example.demo.infrastructure.dto.PokemonJpaDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class PokemonControllerTest {
    
    @Autowired
    private PokemonController pokemonController;
    
    @Autowired
    private PokemonJpaTestDao pokemonTestDao;
 
    @Test
    void shouldSavePokemon_whenPostIsCalled() {
        // Arrange
        PokemonJsonDto pokemonName = new PokemonJsonDto("pokemon-name");

        // Act
        pokemonController.savePokemon(pokemonName);
        
        // Assert
        List<PokemonJpaDto> savedPokemonJpaDtos = pokemonTestDao.findAll();
        PokemonJpaDto expectedPokemonJpaDto = new PokemonJpaDto(1L, "pokemon-name");
        
        assertThat(savedPokemonJpaDtos).containsExactly(expectedPokemonJpaDto);
    }

}