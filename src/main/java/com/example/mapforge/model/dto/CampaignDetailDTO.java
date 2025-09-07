package com.example.mapforge.model.dto;

import com.example.mapforge.model.entity.*;
import com.example.mapforge.model.entity.Character;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record CampaignDetailDTO(UUID id, String name, String description, Map map,
                                Set<CampaignMemberDetailDTO> members) {
    public static CampaignDetailDTO fromEntity(Campaign campaign) {
        return new CampaignDetailDTO(
                campaign.getId(),
                campaign.getName(),
                campaign.getDescription(),
                campaign.getMap(),
                campaign.getCampaignMembers().stream().map(CampaignMemberDetailDTO::fromEntity).collect(Collectors.toSet())
        );
    }
}
