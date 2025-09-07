package com.example.mapforge.model.dto;

import com.example.mapforge.constants.Alignment;
import com.example.mapforge.constants.Race;
import com.example.mapforge.model.entity.Character;

public record CharacterSummaryDTO(
        Integer id,
        String name,
        Race race,
        Alignment alignment
        ) {
    public static  CharacterSummaryDTO fromEnity(Character character) {
        return new CharacterSummaryDTO(
                character.getId(),
                character.getName(),
                character.getRace(),
                character.getAlignment()
        );
    }
}
