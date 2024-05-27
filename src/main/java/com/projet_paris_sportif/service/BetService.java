package com.projet_paris_sportif.service;

import com.projet_paris_sportif.model.Bet;
import com.projet_paris_sportif.model.BetKey;
import com.projet_paris_sportif.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService {
    @Autowired
    private BetRepository betRepository;

    public Bet createBet(Bet bet) {
        return betRepository.save(bet);
    }

    public Bet cancelBet(BetKey betKey) {
        Bet betDeleted = betRepository.getReferenceById(betKey);
        betRepository.delete(betDeleted);
        return betDeleted;
    }

    public Bet getBet(BetKey id) {
        return betRepository.getReferenceById(id);
    }

    public List<Bet> getUserBets(String userId) {
        return betRepository.findAllByUserId(userId);
    }
}
