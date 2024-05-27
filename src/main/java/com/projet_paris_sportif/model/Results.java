package com.projet_paris_sportif.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Results extends Game{
	private Boolean victeam1;
	private Boolean victeam2;
	private Boolean tie;
	
}
