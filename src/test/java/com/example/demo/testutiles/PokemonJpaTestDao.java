package com.example.demo.testutiles;

import com.example.demo.infrastructure.dto.PokemonJpaDto;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public interface PokemonJpaTestDao extends JpaRepository<PokemonJpaDto, Long> {
}
