package com.projet_paris_sportif.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Results extends Game{
	private Integer victeam1;
	private Integer victeam2;
	private Double tie;
	
}
