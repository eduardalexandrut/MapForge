package com.example.mapforge.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class TurnPK implements Serializable {
    @Column(name = "index")
    private int index;

    @Column(name = "campaignId")
    private Long campaignId;
}