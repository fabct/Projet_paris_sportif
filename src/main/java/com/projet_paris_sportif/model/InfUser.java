package com.projet_paris_sportif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class InfUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String name;

	private String surname;

	private String password;

	private Integer birthyear;

	private String role;
}
