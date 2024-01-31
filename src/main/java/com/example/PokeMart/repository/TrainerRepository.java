package com.example.PokeMart.repository;

import com.example.PokeMart.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Trainer findByUsername(String username);
}
