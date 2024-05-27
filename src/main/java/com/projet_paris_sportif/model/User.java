package com.projet_paris_sportif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;


@Entity
@Data
public class User extends InfUser{
	
	private Integer solde;
	
	@OneToMany(mappedBy = "user")
    private Set<Bet> sum;
	
	
}
