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
    private static final long serialVersionUID = -8205427271119416028L;

    @Column(name = "index")
    private int index;

    @Column(name = "campaignId")
    private Long campaignId;
}