package com.example.mapforge.model;

import com.example.mapforge.constants.Alignment;
import com.example.mapforge.constants.Race;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private Race race;

    private Alignment alignment;

    private Integer armor;

    private Integer speed;

    private String weaponDamage;// e.g., "1d8", "2d6"

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

}
