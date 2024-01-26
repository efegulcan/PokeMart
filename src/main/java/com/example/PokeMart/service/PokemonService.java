package com.example.PokeMart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PokeMart.model.Pokemon;
import com.example.PokeMart.repository.PokemonRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getRandomPokemons(int count) {
        List<Pokemon> allPokemons = pokemonRepository.findAll();
        Collections.shuffle(allPokemons);
        return allPokemons.stream().limit(count).collect(Collectors.toList());
    }

}
