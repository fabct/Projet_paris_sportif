package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.dto.BetDto;
import com.projet_paris_sportif.model.Bet;
import com.projet_paris_sportif.model.BetKey;
import com.projet_paris_sportif.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BetController extends Exception {

    @Autowired
    private BetService betService;

    @GetMapping("/userBets")
    public List<BetDto> getUserBet(@RequestParam Integer userId) {
        return betService.getUserBets(userId);
    }

    @GetMapping("/bet")
    public BetDto getBet(@RequestParam BetKey id) throws ResourceNotFoundException {
        return betService.getBet(id);
    }

    @PostMapping("/bet")
    public BetDto createBet(@RequestBody Bet bet) {
        return betService.createBet(bet);
    }

    @DeleteMapping("/bet")
    public BetDto cancelBet(BetKey id) throws ResourceNotFoundException {
        return betService.cancelBet(id);
    }
}
