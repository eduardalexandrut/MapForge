package com.example.mapforge.service;

import com.example.mapforge.model.dto.AuthResponseDTO;
import com.example.mapforge.model.entity.Campaign;
import com.example.mapforge.model.entity.Character;
import com.example.mapforge.model.entity.User;
import com.example.mapforge.repository.CampaignRepository;
import com.example.mapforge.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public Optional<Campaign> createCampaign(Campaign campaign) {
       return Optional.of(campaignRepository.save(campaign));
    }

    public Optional<Campaign> updateCampaign(String id, Campaign updatedCampaign) {
        Optional<Campaign> oldCampaign = campaignRepository.findById(id);

        if (oldCampaign.isEmpty()) {
            return Optional.empty();
        }

        oldCampaign.get().setName(
                Optional.ofNullable(updatedCampaign.getName()).orElse(oldCampaign.get().getName())
        );
        oldCampaign.get().setDescription(
                Optional.ofNullable(updatedCampaign.getDescription()).orElse(oldCampaign.get().getDescription())
        );
        oldCampaign.get().setMap(
                Optional.ofNullable(updatedCampaign.getMap()).orElse(oldCampaign.get().getMap())
        );

        return Optional.of(campaignRepository.save(oldCampaign.get()));
    }

    //FIXME set value null to fks
    public Optional<Campaign> deleteCampaign(String id) {
        Optional<Campaign> campaign = campaignRepository.findById(id);

        if (campaign.isEmpty()) {
            return Optional.empty();
        }

        campaignRepository.deleteById(id);
        return campaign;
    }
}
