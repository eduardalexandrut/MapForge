package com.example.mapforge.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    private Race race;

//    private Alignment alignment;

    //TODO move into CampaignCharacter
//    private Integer xpPoints;
//
//    private Integer hp;

    private Integer armor;

    private Integer speed;

    private String weaponDamage;// e.g., "1d8", "2d6"

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

}
