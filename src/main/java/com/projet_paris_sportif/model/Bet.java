package com.projet_paris_sportif.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Bet {
	
	@EmbeddedId
	private BetKey id;
	
	@ManyToOne
	@MapsId("idUser")
	@JoinColumn(name = "id_user")
	private User user;
	
	@ManyToOne
	@MapsId("idMatch")
	@JoinColumn(name = "id_match")
	private Game match;
	
	private Integer sum;
}
