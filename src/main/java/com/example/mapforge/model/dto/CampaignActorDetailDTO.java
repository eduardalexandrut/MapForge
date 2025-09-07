package com.example.mapforge.model.dto;

import com.example.mapforge.model.entity.AbstractEntity;
import com.example.mapforge.model.entity.CampaignActor;
import com.example.mapforge.model.entity.Character;
import com.example.mapforge.model.entity.Npc;

import java.util.UUID;

public record CampaignActorDetailDTO(
        Integer id,
        UUID campaignId,
        String type,
        Integer xp,
        Integer hp,
        Character character,
        Npc npc
) {
    public static CampaignActorDetailDTO fromEntity(CampaignActor actor) {
        return new CampaignActorDetailDTO(
                actor.getId(),
                actor.getCampaign() != null ? actor.getCampaign().getId() : null,
                actor.getType(),
                actor.getXp(),
                actor.getHp(),
                actor.getCharacter(),
                actor.getNpc()
        );
    }
}