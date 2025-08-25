package com.example.mapforge.controller;

import com.example.mapforge.model.entity.Character;
import com.example.mapforge.model.entity.User;
import com.example.mapforge.repository.CharacterRepository;
import com.example.mapforge.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    private final CharacterRepository characterRepository;

    private final CharacterService characterService;

    public CharacterController(CharacterRepository characterRepository, CharacterService characterService) {
        this.characterRepository = characterRepository;
        this.characterService = characterService;
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

    // PUT /api/v1/characters/{id} -> update a character
    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Integer id, @RequestBody Character character) {
        return characterService.updateCharacter(id, character)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE /api/v1/characters/{id} -> delete a character
    @DeleteMapping("/{id}")
    public ResponseEntity<Character> deleteCharacter(@PathVariable Integer id) {
        return characterService.deleteCharacter(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
