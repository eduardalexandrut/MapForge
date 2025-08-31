package com.example.mapforge.service;

import com.example.mapforge.model.dto.AuthResponseDTO;
import com.example.mapforge.model.dto.CampaignDetailDTO;
import com.example.mapforge.model.dto.CampaignSummaryDTO;
import com.example.mapforge.model.entity.Campaign;
import com.example.mapforge.model.entity.Character;
import com.example.mapforge.model.entity.User;
import com.example.mapforge.repository.CampaignRepository;
import com.example.mapforge.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public Optional<Campaign> createCampaign(Campaign campaign) {
       return Optional.of(campaignRepository.save(campaign));
    }

    public Set<CampaignSummaryDTO> findAllCampaignSummaries() {
        return campaignRepository.findAll().stream()
                .map(CampaignSummaryDTO::fromEntity)
                .collect(Collectors.toSet());
    }

    public Optional<CampaignDetailDTO> updateCampaign(String id, CampaignDetailDTO updatedCampaign) {
        return campaignRepository.findById(id)
                .map(oldCampaign -> {
                    oldCampaign.setName(Optional.ofNullable(updatedCampaign.name()).orElse(oldCampaign.getName()));
                    oldCampaign.setDescription(Optional.ofNullable(updatedCampaign.description()).orElse(oldCampaign.getDescription()));
                    oldCampaign.setMap(Optional.ofNullable(updatedCampaign.map()).orElse(oldCampaign.getMap()));

                    Campaign savedCampaign = campaignRepository.save(oldCampaign);

                    return CampaignDetailDTO.fromEntity(savedCampaign);
                });
    }


    //FIXME set value null to fks
    public Optional<CampaignSummaryDTO> deleteCampaign(String id) {
        Optional<Campaign> campaign = campaignRepository.findById(id);

        if (campaign.isEmpty()) {
            return Optional.empty();
        }

        campaignRepository.deleteById(id);
        return Optional.of(CampaignSummaryDTO.fromEntity(campaign.get()));
    }
}
