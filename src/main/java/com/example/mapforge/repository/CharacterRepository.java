package com.example.mapforge.repository;

import com.example.mapforge.model.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

    public Optional<Character> findByName(String name);

    public Optional<Character> findById(Integer id);
}
