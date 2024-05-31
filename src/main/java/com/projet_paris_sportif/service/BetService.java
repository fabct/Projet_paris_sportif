package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.dto.bet.BetDto;
import com.projet_paris_sportif.dto.game.GameDto;
import com.projet_paris_sportif.dto.game.GameResultsDto;
import com.projet_paris_sportif.dto.game.GameTeamDto;
import com.projet_paris_sportif.model.Bet;
import com.projet_paris_sportif.model.BetKey;
import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.model.Results;
import com.projet_paris_sportif.model.Team;
import com.projet_paris_sportif.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BetService {
    @Autowired
    private BetRepository betRepository;

    public BetDto createBet(Bet bet) {
        return convertBetToDto(betRepository.save(bet));
    }

    public BetDto cancelBet(BetKey betKey) throws ResourceNotFoundException {
        Bet betDeleted = betRepository.getReferenceById(betKey);
        betRepository.delete(betDeleted);
        return convertBetToDto(betRepository.findById(betKey)
                .orElseThrow(() -> new ResourceNotFoundException("Ce pari n'existe pas ou a bien été supprimé !")));
    }

    public BetDto getBet(BetKey id) throws ResourceNotFoundException {
        return convertBetToDto(
                betRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ce pari n'existe pas !")));
    }

    public List<BetDto> getUserBets(Integer userId) {
        return betRepository.findAllByUserId(userId).stream()
                .map(this::convertBetToDto)
                .collect(Collectors.toList());
    }

    public BetDto convertBetToDto(Bet b) {
        return BetDto.builder()
                .id(b.getId())
                .user(b.getUser())
                .game(convertGameToDto(b.getMatch()))
                .sum(b.getSum())
                .build();
    }

    public GameDto convertGameToDto(Game g) {
        return GameDto.builder()
                .idMatch(g.getIdMatch())
                .sidevic1(g.getSidevic1())
                .sidevic2(g.getSidevic2())
                .tie(g.getTie())
                .teams(g.getTeams().stream().map(this::convertTeamBetToDto).collect(Collectors.toList()))
                .sum(g.getSum())
                .result(convertGameResultsToDto(g.getResult()))
                .build();
    }

    public GameTeamDto convertTeamBetToDto(Team t) {
        return GameTeamDto.builder()
                .idTeam(t.getIdTeam())
                .teamname(t.getTeamname())
                .build();
    }

    public GameResultsDto convertGameResultsToDto(Results r) {
        if (r == null)
            return null;
        return GameResultsDto.builder()
                .idResult(r.getIdResult())
                .resultVicTeam1(r.getResultVicTeam1())
                .resultVicTeam2(r.getResultVicTeam2())
                .resultTie(r.getResultTie())
                .build();
    }
}
