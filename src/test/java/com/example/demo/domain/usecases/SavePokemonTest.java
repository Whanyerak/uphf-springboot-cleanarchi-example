package com.example.demo.domain.usecases;

import com.example.demo.domain.bean.Pokemon;
import com.example.demo.infrastructure.adapter.PokemonAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SavePokemonTest {
    
    private SavePokemon savePokemon;
    
    @Mock
    private PokemonAdapter pokemonAdapter;
    
    @BeforeEach
    public void setUp() {
        savePokemon = new SavePokemon(pokemonAdapter);
    }
    
    @Test
    void shouldSavePokemon_whenNameReceived() {
        // Arrange
        Pokemon pokemon = new Pokemon("pokemon-name");

        // Act
        savePokemon.execute(pokemon);
        
        // Assert
        Pokemon expectedPokemon = new Pokemon("pokemon-name");
        
        verify(pokemonAdapter).save(expectedPokemon);
    }

}