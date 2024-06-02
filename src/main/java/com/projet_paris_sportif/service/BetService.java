package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.dto.bet.BetResponseDTO;
import com.projet_paris_sportif.dto.game.GameResponseDTO;
import com.projet_paris_sportif.dto.game.GameResultsDto;
import com.projet_paris_sportif.dto.game.GameTeamDto;
import com.projet_paris_sportif.mapper.BetMapper;
import com.projet_paris_sportif.model.Bet;
import com.projet_paris_sportif.model.BetKey;
import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.model.Results;
import com.projet_paris_sportif.model.Team;
import com.projet_paris_sportif.model.User;
import com.projet_paris_sportif.repository.BetRepository;
import com.projet_paris_sportif.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BetService {
    @Autowired
    private BetRepository betRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BetMapper betMapper;

    public BetResponseDTO createBet(Bet bet) {
        User user = userRepository.findById(bet.getUser().getId()).get();
        Integer solde = user.getSolde();
        Integer newSolde = 0;
        Integer betAmount = bet.getSum();
        if (!betRepository.findById(bet.getId()).isEmpty()) {
            Integer currentBetAmount = betRepository.findById(bet.getId()).get().getSum();
            newSolde = solde + currentBetAmount - betAmount;
        } else {
            newSolde = solde - betAmount;
        }
        user.setSolde(newSolde);
        userRepository.save(user);

        return betMapper.BetToBetResponseDTO(betRepository.save(bet));
    }

    public BetResponseDTO cancelBet(BetKey betKey) throws ResourceNotFoundException {
        Bet betDeleted = betRepository.getReferenceById(betKey);
        betRepository.delete(betDeleted);
        return betMapper.BetToBetResponseDTO(betRepository.findById(betKey)
                .orElseThrow(() -> new ResourceNotFoundException("Ce pari n'existe pas ou a bien été supprimé !")));
    }

    public BetResponseDTO getBet(BetKey id) throws ResourceNotFoundException {
        return betMapper.BetToBetResponseDTO(
                betRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ce pari n'existe pas !")));
    }

    public List<BetResponseDTO> getUserBets(Integer userId) {
        return betMapper.mapBetsToBetResponseDtos(betRepository.findAllByUserId(userId));
    }
}
