package com.projet_paris_sportif.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@Embeddable
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMatch;

	private Double sidevic1;

	private Double sidevic2;

	private Double tie;

	@ManyToMany
	@JoinTable(name = "TeamMatch", joinColumns = @JoinColumn(name = "id_match"), inverseJoinColumns = @JoinColumn(name = "id_team"))
	private List<Team> teams;

	@OneToMany(mappedBy = "match")
	private List<Bet> sum;

	@OneToOne(mappedBy = "game")
	private Results result;
}
