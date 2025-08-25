package com.example.mapforge.service;

import com.example.mapforge.model.entity.Character;
import com.example.mapforge.model.entity.User;
import com.example.mapforge.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Optional<Character> updateCharacter(Integer id, Character updatedCharacter) {
        Optional<Character> oldCharacter = characterRepository.findById(id);

        if (oldCharacter.isEmpty()) {
            return Optional.empty();
        }

        oldCharacter.get().setName(
                Optional.ofNullable(updatedCharacter.getName()).orElse(oldCharacter.get().getName())
        );
        oldCharacter.get().setArmor(
                Optional.ofNullable(updatedCharacter.getArmor()).orElse(oldCharacter.get().getArmor())
        );
        oldCharacter.get().setSpeed(
                Optional.ofNullable(updatedCharacter.getSpeed()).orElse(oldCharacter.get().getSpeed())
        );
        oldCharacter.get().setWeaponDamage(
                Optional.ofNullable(updatedCharacter.getWeaponDamage()).orElse(oldCharacter.get().getWeaponDamage())
        );
        oldCharacter.get().setAlignment(
                Optional.ofNullable(updatedCharacter.getAlignment()).orElse(oldCharacter.get().getAlignment())
        );
        oldCharacter.get().setRace(
                Optional.ofNullable(updatedCharacter.getRace()).orElse(oldCharacter.get().getRace())
        );

        return Optional.of(characterRepository.save(oldCharacter.get()));
    }

    //FIXME set value null to fks
    public Optional<Character> deleteCharacter(Integer id) {
        Optional<Character> character = characterRepository.findById(id);

        if (character.isEmpty()) {
            return Optional.empty();
        }

        characterRepository.deleteById(id);
        return character;
    }
}
