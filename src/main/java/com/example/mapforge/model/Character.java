package com.example.mapforge.model;

import com.example.mapforge.constants.Alignment;
import com.example.mapforge.constants.Race;
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator", nullable = false)
    private User creator;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "armor", nullable = false)
    private Integer armor;
    
    @Column(name = "speed", nullable = false)
    private Integer speed;
    
    @Column(name = "weapon_damage", nullable = false)
    private Integer weaponDamage;

    @Column(name = "race", nullable = false)
    private Race race;

    @Column(name = "alignment", nullable = false)
    private Alignment alignment;
}