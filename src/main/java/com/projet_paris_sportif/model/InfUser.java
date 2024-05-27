package com.projet_paris_sportif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class InfUser {
	@Id
	private String IdUser;
	private String name;
	private String surname;
	private String password;
	private Integer birthyear;
	private String role;
}
