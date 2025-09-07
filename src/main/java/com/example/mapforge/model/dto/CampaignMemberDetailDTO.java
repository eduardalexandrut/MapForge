package com.example.mapforge.model.dto;

import com.example.mapforge.model.entity.CampaignActor;
import com.example.mapforge.model.entity.CampaignMember;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record CampaignMemberDetailDTO(UUID ownerId, String ownerName, String role, Set<CampaignActorDetailDTO> actors) {
    public static CampaignMemberDetailDTO fromEntity(CampaignMember campaignMember) {
        return new CampaignMemberDetailDTO(
                campaignMember.getCampaign().getId(),
                campaignMember.getOwner().getUsername(),
                campaignMember.getRole(),
                campaignMember.getCampaignActors().stream().map(CampaignActorDetailDTO::fromEntity).collect(Collectors.toSet())
        );
    }
}