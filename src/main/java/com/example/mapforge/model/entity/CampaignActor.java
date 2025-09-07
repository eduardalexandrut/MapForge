package com.example.mapforge.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyDiscriminator;
import org.hibernate.annotations.AnyDiscriminatorValue;
import org.hibernate.annotations.AnyKeyJavaClass;


@Getter
@Setter
@Entity
@Table(name = "campaign_actors")
public class CampaignActor {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "campaign", nullable = false)
    private Campaign campaign;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "xp", nullable = false)
    private Integer xp;
    
    @Column(name = "hp", nullable = false)
    private Integer hp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "owner", referencedColumnName = "owner", insertable = false, updatable = false),
            @JoinColumn(name = "campaign", referencedColumnName = "campaign", insertable = false, updatable = false)
    })
    private CampaignMember campaignMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character")
    private Character character;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "npc")
    private Npc npc;
}