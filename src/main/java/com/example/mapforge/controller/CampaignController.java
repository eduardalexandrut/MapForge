package com.example.mapforge.controller;

import com.example.mapforge.model.entity.Campaign;
import com.example.mapforge.model.entity.Character;
import com.example.mapforge.repository.CampaignRepository;
import com.example.mapforge.repository.CharacterRepository;
import com.example.mapforge.service.CampaignService;
import com.example.mapforge.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/campaigns")
public class CampaignController {

    private final CampaignRepository campaignRepository;

    private final CampaignService campaignService;

    public CampaignController(CampaignRepository campaignRepository, CampaignService campaignService) {
        this.campaignRepository = campaignRepository;
        this.campaignService = campaignService;
    }

    @PostMapping
    public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign) {
        return campaignService.createCampaign(campaign)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    // GET /api/campaigns → all campaigns
    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    // GET /api/campaigns/{id} → single campaigns by id
    @GetMapping("/{id}")
    public Campaign getCampaignById(@PathVariable Integer id) {
        return campaignRepository.findById(id).orElse(null);
    }

    // PUT /api/v1/campaigns/{id} -> update a campaign
    @PutMapping("/{id}")
    public ResponseEntity<Campaign> updateCampaign(@PathVariable Integer id, @RequestBody Campaign campaign) {
        return campaignService.updateCampaign(id, campaign)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE /api/v1/campaigns/{id} -> delete a campaign
    @DeleteMapping("/{id}")
    public ResponseEntity<Campaign> deleteCampaign(@PathVariable Integer id) {
        return campaignService.deleteCampaign(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
