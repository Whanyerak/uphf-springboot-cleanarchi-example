package com.example.demo.infrastructure.dao;

import com.example.demo.infrastructure.dto.PokemonJpaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonJpaDao extends JpaRepository<PokemonJpaDto, Long> {

    Optional<PokemonJpaDto> findPokemonByName(String name);
    
}
