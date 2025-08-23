package com.example.mapforge.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class TurnPK implements Serializable {
    private int index;
    private Long campaignId;
}