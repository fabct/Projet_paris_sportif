package com.projet_paris_sportif.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class InfUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private String surname;

	private String password;

	private String birthyear;

	private String role;
}
