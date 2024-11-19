package com.example.demo.domain.bean;

import lombok.Getter;

import java.util.Objects;

public class Pokemon {
    
    @Getter
    private final String name;

    public Pokemon(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(name, pokemon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
    
}
