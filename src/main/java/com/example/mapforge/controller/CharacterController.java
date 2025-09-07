package com.example.mapforge.controller;

import com.example.mapforge.model.dto.CharacterDetailDTO;
import com.example.mapforge.model.dto.CharacterSummaryDTO;
import com.example.mapforge.model.entity.Character;
import com.example.mapforge.model.entity.User;
import com.example.mapforge.repository.CharacterRepository;
import com.example.mapforge.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    // GET /api/characters → all characters
    @GetMapping
    public Set<CharacterSummaryDTO> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    // GET /api/characters/{id} → single characters by id
    @GetMapping("/{id}")
    public CharacterDetailDTO getCharacterById(@PathVariable Integer id) {
        return characterService.getCharacterById(id);
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
