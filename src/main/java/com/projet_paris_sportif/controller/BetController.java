package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.dto.bet.BetResponseDTO;
import com.projet_paris_sportif.model.Bet;
import com.projet_paris_sportif.model.BetKey;
import com.projet_paris_sportif.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BetController extends Exception {

    @Autowired
    private BetService betService;

    @GetMapping("/userBets")
    public List<BetResponseDTO> getUserBet(@RequestParam Integer userId) {
        return betService.getUserBets(userId);
    }

    @GetMapping("/bet")
    public BetResponseDTO getBet(@RequestParam BetKey id) throws ResourceNotFoundException {
        return betService.getBet(id);
    }

    @PostMapping("/bet")
    public BetResponseDTO createBet(@RequestBody Bet bet) {
        return betService.createBet(bet);
    }

    @DeleteMapping("/bet")
    public BetResponseDTO cancelBet(BetKey id) throws ResourceNotFoundException {
        return betService.cancelBet(id);
    }
}
