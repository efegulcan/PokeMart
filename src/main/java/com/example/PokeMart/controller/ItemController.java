package com.example.PokeMart.controller;

import com.example.PokeMart.model.Item;
import com.example.PokeMart.model.Pokemon;
import com.example.PokeMart.repository.ItemRepository;
import com.example.PokeMart.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/items")
    public String getAllItems(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "item-list.html";
    }
}
