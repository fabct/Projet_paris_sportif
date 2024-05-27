package com.projet_paris_sportif.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Embeddable
public class Game{
	@Id
	private String idMatch;
	private Double sidevic1;
	private Double sidevic2;
	private Double tie;
	
	@ManyToMany
	@JoinTable(name = "TeamMatch",joinColumns = @JoinColumn(name = "id_match"),
	inverseJoinColumns = @JoinColumn(name = "id_team"))
	private List<Team> teams;

	
	@OneToMany(mappedBy = "match")
    private Set<Bet> sum;
	
	
}
