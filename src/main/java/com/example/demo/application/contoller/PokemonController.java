package com.example.demo.application.contoller;

import com.example.demo.application.dto.PokemonJsonDto;
import com.example.demo.application.mapper.ApplicationToDomainMapper;
import com.example.demo.application.mapper.DomainToApplicationMapper;
import com.example.demo.domain.bean.Pokemon;
import com.example.demo.domain.usecases.GetPokemon;
import com.example.demo.domain.usecases.SavePokemon;
import com.example.demo.infrastructure.dto.PokemonJpaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    
    private final GetPokemon getPokemon;
    private final SavePokemon savePokemon;
    
    private final DomainToApplicationMapper fromDomainMapper;
    private final ApplicationToDomainMapper toDomainMapper;

    public PokemonController(GetPokemon getPokemon, SavePokemon savePokemon, DomainToApplicationMapper fromDomainMapper, ApplicationToDomainMapper toDomainMapper) {
        this.getPokemon = getPokemon;
        this.savePokemon = savePokemon;
        this.fromDomainMapper = fromDomainMapper;
        this.toDomainMapper = toDomainMapper;
    }

    @GetMapping("/{name}")
    public ResponseEntity<PokemonJsonDto> getPokemon(@PathVariable String name) {
        Pokemon pokemon = getPokemon.execute(name);
        
        return ok(fromDomainMapper.mapFromPokemon(pokemon));
    }
    
    @PostMapping
    public ResponseEntity<PokemonJpaDto> savePokemon(@RequestBody PokemonJsonDto pokemonJsonDto) {
        savePokemon.execute(toDomainMapper.mapToPokemon(pokemonJsonDto));
        
        return ok().build();
    }
    
}
