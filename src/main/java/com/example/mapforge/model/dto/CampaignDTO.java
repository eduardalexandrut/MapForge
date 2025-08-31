package com.example.mapforge.model.dto;

import com.example.mapforge.model.entity.Campaign;
import com.example.mapforge.model.entity.Map;

import java.util.UUID;

public record CampaignDTO(UUID id, String name, String description, Map map) {
    public static CampaignDTO fromEntity(Campaign campaign) {
        return new CampaignDTO(
                campaign.getId(),
                campaign.getName(),
                campaign.getDescription(),
                campaign.getMap()
        );
    }
}
