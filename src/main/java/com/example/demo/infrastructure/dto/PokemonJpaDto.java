package com.example.demo.infrastructure.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Entity
@ToString
@NoArgsConstructor
public class PokemonJpaDto {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String name;

    public PokemonJpaDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PokemonJpaDto(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonJpaDto pokemonJpaDto = (PokemonJpaDto) o;
        return Objects.equals(id, pokemonJpaDto.id) && Objects.equals(name, pokemonJpaDto.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        return result;
    }
    
}
