package com.projet_paris_sportif.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Team {
	@Id
	private String idTeam;
	private String teamname;
	//association
	@ManyToMany
	@JoinTable(name = "TeamMatch",joinColumns = @JoinColumn(name = "id_team")
	,inverseJoinColumns = @JoinColumn(name = "id_match"))
	private List<Game> matchs;
	
	

	
}
