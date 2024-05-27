package com.projet_paris_sportif.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTeam;

	private String teamname;
	//association
	@ManyToMany
	@JoinTable(name = "TeamMatch",joinColumns = @JoinColumn(name = "id_team")
	,inverseJoinColumns = @JoinColumn(name = "id_match"))
	private List<Game> matchs;
	
	

	
}
