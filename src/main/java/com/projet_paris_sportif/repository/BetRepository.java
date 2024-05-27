package com.projet_paris_sportif.repository;

import com.projet_paris_sportif.model.Bet;
import com.projet_paris_sportif.model.BetKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, BetKey>{
    List<Bet> findAllByUserId(Integer userId);
}
