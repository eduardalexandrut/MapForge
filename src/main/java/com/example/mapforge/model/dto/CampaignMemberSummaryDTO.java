package com.example.mapforge.model.dto;

import com.example.mapforge.model.entity.CampaignMember;

import java.util.UUID;

public record CampaignMemberSummaryDTO(UUID ownerId, String ownerName, String role) {
    public static CampaignMemberSummaryDTO fromEntity(CampaignMember campaignMember) {
        return new CampaignMemberSummaryDTO(
                campaignMember.getCampaign().getId(),
                campaignMember.getOwner().getUsername(),
                campaignMember.getRole()
        );
    }
}
