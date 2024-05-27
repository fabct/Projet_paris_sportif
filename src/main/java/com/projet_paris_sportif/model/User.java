package com.projet_paris_sportif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User extends InfUser {

	private Integer solde;

	@OneToMany(mappedBy = "user")
	private Set<Bet> sum;

}
