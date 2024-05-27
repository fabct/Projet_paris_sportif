package com.projet_paris_sportif.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Results extends Game{
	private Boolean resultVicTeam1;
	private Boolean resultVicTeam2;
	private Boolean resultTie;
	
}
