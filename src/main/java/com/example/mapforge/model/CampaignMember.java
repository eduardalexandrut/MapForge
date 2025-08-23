package com.example.mapforge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class CampaignMember implements Serializable {
    @EmbeddedId
    private CampaignMemberPK id;

    @MapsId("ownerId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private User owner;

    @MapsId("campaignId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign")
    private Campaign campaign;

    @Column(nullable = false)
    private String role;
}
