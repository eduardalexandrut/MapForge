package com.example.mapforge.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pawn implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private PawnPK id;

    @ManyToOne
    @MapsId("campaignId") // This ensures that the campaignId from the composite key is set correctly
    private Campaign campaign;

    @ManyToOne
    @MapsId("userId") // This ensures that the userId from the composite key is set correctly
    private User player;

//    @Embedded
//    private Position position;
}
