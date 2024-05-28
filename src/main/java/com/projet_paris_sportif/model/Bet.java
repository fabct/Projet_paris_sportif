package com.projet_paris_sportif.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
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
