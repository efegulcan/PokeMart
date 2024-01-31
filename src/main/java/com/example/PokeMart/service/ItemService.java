package com.example.PokeMart.service;

import com.example.PokeMart.model.Item;
import com.example.PokeMart.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PokeMart.model.Pokemon;
import com.example.PokeMart.repository.PokemonRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getRandomItems(int count) {
        List<Item> allItems = itemRepository.findAll();
        Collections.shuffle(allItems);
        return allItems.stream().limit(count).collect(Collectors.toList());
    }

}
