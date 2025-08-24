package com.example.mapforge.model.entity;

import com.example.mapforge.constants.Alignment;
import com.example.mapforge.constants.Race;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;



@Getter
@Setter
@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "characters"})
    private User creator;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "armor", nullable = false)
    private Integer armor;
    
    @Column(name = "speed", nullable = false)
    private Integer speed;
    
    @Column(name = "weapon_damage", nullable = false)
    private Integer weaponDamage;

    @Enumerated(EnumType.STRING)
    @Column(name = "race", nullable = false)
    private Race race;

    @Enumerated(EnumType.STRING)
    @Column(name = "alignment", nullable = false)
    private Alignment alignment;
}