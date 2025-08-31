package com.example.mapforge.model.dto;

import com.example.mapforge.model.entity.Campaign;
import com.example.mapforge.model.entity.CampaignMember;

import java.util.UUID;

public record CampaignSummaryDTO(UUID id, String name, String description, Integer members) {
    public static CampaignSummaryDTO fromEntity(Campaign campaign) {
        return new CampaignSummaryDTO(
                campaign.getId(),
                campaign.getName(),
                campaign.getDescription(),
                campaign.getCampaignMembers().size()
        );
    }
}
