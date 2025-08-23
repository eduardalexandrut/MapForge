package com.example.mapforge.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CampaignMemberPK implements Serializable {
    private Long ownerId;
    private Long campaignId;

    public CampaignMemberPK(Long ownerId, Long campaignId) {
        this.ownerId = ownerId;
        this.campaignId = campaignId;
    }

    public CampaignMemberPK() {

    }
}
