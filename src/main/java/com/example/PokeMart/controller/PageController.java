package com.example.PokeMart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.PokeMart.service.PokemonService;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PageController {

    private final PokemonService pokemonService;

    public PageController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }
    @GetMapping("/")
    public RedirectView rootRedirect() {
        return new RedirectView("/home");
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("todaysDeals", pokemonService.getRandomPokemons(3));
        return "home";
    }
}
