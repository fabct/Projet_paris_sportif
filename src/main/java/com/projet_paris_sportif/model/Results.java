package com.projet_paris_sportif.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Results {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idResult;

	private Boolean resultVicTeam1;
	private Boolean resultVicTeam2;
	private Boolean resultTie;

	@OneToOne
	@JoinColumn(name = "idMatch")
	private Game game;
}
