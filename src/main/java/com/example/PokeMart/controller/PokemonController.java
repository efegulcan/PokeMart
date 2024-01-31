package com.example.PokeMart.controller;

import com.example.PokeMart.service.PokemonService;
import org.springframework.ui.Model;
import com.example.PokeMart.model.Pokemon;
import com.example.PokeMart.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping("/pokemons")
    public String getAllPokemons(Model model) {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        model.addAttribute("pokemons", pokemons);
        return "pokemon-list.html";
    }

}
