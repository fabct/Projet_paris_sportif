package com.projet_paris_sportif.repository;

import com.projet_paris_sportif.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, Integer>{

}
