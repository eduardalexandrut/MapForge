package com.example.mapforge.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "campaign_actors")
public class CampaignActor {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Campaign campaign;

    private String type;
    
    @Column(name = "ref_id", nullable = false)
    private Integer refId;
    
    @Column(name = "xp", nullable = false)
    private Integer xp;
    
    @Column(name = "hp", nullable = false)
    private Integer hp;

}