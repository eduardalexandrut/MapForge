package com.example.mapforge.model.dto;

import com.example.mapforge.constants.Alignment;
import com.example.mapforge.constants.Race;
import com.example.mapforge.model.entity.Character;

public record CharacterDetailDTO(
        Integer id,
        String name,
        Race race,
        Alignment alignment,
        Integer armor,
        Integer speed,
        Integer weaponDamage,
        UserSummaryDTO user
) {
    public static  CharacterDetailDTO fromEnity(Character character) {
        return new CharacterDetailDTO(
                character.getId(),
                character.getName(),
                character.getRace(),
                character.getAlignment(),
                character.getArmor(),
                character.getSpeed(),
                character.getWeaponDamage(),
                UserSummaryDTO.fromEntity(character.getCreator())
        );
    }
}
