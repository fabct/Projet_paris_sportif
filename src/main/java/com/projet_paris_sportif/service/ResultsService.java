package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.dto.BetUserDto;
import com.projet_paris_sportif.dto.GameTeamDto;
import com.projet_paris_sportif.dto.ResultsDto;
import com.projet_paris_sportif.dto.ResultsGameBetDto;
import com.projet_paris_sportif.dto.ResultsGameDto;
import com.projet_paris_sportif.model.Bet;
import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.model.Results;
import com.projet_paris_sportif.model.Team;
import com.projet_paris_sportif.model.User;
import com.projet_paris_sportif.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultsService {
    @Autowired
    private ResultsRepository resultsRepository;

    public ResultsDto createResult(Results results) {
        return convertResultsToDto(resultsRepository.save(results));
    }

    public ResultsDto getResult(Integer id) throws ResourceNotFoundException {
        return convertResultsToDto(resultsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce résultat n'existe pas !")));
    }

    public List<ResultsDto> getAllResults() {
        return resultsRepository.findAll().stream()
                .map(this::convertResultsToDto).collect(Collectors.toList());
    }

    public ResultsDto deleteResult(Integer id) throws ResourceNotFoundException {
        Results resultDelete = resultsRepository.getReferenceById(id);
        resultsRepository.delete(resultDelete);
        return convertResultsToDto(resultsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce résultat n'existe pas ou a bien été supprimé !")));
    }

    public ResultsDto convertResultsToDto(Results r) {
        return ResultsDto.builder()
                .idResult(r.getIdResult())
                .resultVicTeam1(r.getResultVicTeam1())
                .resultVicTeam2(r.getResultVicTeam2())
                .resultTie(r.getResultTie())
                .game(convertResultsGameToDto(r.getGame()))
                .build();
    }

    public ResultsGameDto convertResultsGameToDto(Game g) {
        return ResultsGameDto.builder()
                .idMatch(g.getIdMatch())
                .sidevic1(g.getSidevic1())
                .sidevic2(g.getSidevic2())
                .tie(g.getTie())
                .teams(g.getTeams().stream().map(this::convertTeamBetToDto).collect(Collectors.toList()))
                // .sum((g.getSum().stream().map(this::convertResultsGameBetToDto).collect(Collectors.toSet())))
                .build();
    }

    public GameTeamDto convertTeamBetToDto(Team t) {
        return GameTeamDto.builder()
                .idTeam(t.getIdTeam())
                .teamname(t.getTeamname())
                .build();
    }

    public ResultsGameBetDto convertResultsGameBetToDto(Bet b) {
        return ResultsGameBetDto.builder()
                .id(b.getId())
                .user(convertBetUserToDto(b.getUser()))
                .sum(b.getSum())
                .build();
    }

    public BetUserDto convertBetUserToDto(User u) {
        return BetUserDto.builder()
                .solde(u.getSolde())
                .build();
    }
}
