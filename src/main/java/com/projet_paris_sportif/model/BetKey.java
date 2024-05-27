package com.projet_paris_sportif.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BetKey implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_match")
    private Integer idMatch;

}