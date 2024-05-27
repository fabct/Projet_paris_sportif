package com.projet_paris_sportif.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Results extends Game {
	private Boolean resultVicTeam1;
	private Boolean resultVicTeam2;
	private Boolean resultTie;

}
