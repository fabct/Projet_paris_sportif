package com.projet_paris_sportif.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
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