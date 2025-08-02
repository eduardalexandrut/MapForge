package com.example.mapforge.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Entity
public class Campaign implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

//    @ManyToOne
//    private User master;
//
//    @ManyToMany
//    private List<User> players;

    // One map associated with the campaign
//    @OneToOne(cascade = CascadeType.ALL)
//    private GameMap map;

    // All pawns on the map
//    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
//    private List<Pawn> pawns;

    // Index to track current turn
//    private int currentTurnIndex;
}
