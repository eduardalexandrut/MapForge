package com.example.mapforge.controller;

import com.example.mapforge.model.entity.Character;
import com.example.mapforge.repository.CharacterRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    private final CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    // GET /api/characters → all characters
    @GetMapping
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    // GET /api/characters/{id} → single characters by id
    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Integer id) {
        return characterRepository.findById(id).orElse(null);
    }
}
