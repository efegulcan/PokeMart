package com.example.PokeMart.controller;

import com.example.PokeMart.model.Trainer;
import com.example.PokeMart.repository.TrainerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TrainerController {

    @Autowired
    private TrainerRepository trainerRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("trainer", new Trainer());
        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("trainer") Trainer trainer) {
        trainer.setPassword(new BCryptPasswordEncoder().encode(trainer.getPassword()));
        trainerRepository.save(trainer);
        return "redirect:/login";
    }
}

