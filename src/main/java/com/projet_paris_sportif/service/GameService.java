package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.dto.GameDto;
import com.projet_paris_sportif.dto.GameResultsDto;
import com.projet_paris_sportif.dto.GameTeamDto;
import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.model.Results;
import com.projet_paris_sportif.model.Team;
import com.projet_paris_sportif.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameDto> getAllGame() {
        return gameRepository.findAll().stream()
                .map(this::convertGameToDto)
                .collect(Collectors.toList());
    }

    public GameDto getGame(Integer id) throws ResourceNotFoundException {
        return convertGameToDto(gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce match n'existe pas !")));
    }

    public GameDto createGame(Game game) {
        return convertGameToDto(gameRepository.save(game));
    }

    public GameDto deleteGame(Integer id) throws ResourceNotFoundException {
        Game gameDelete = gameRepository.getReferenceById(id);
        gameRepository.delete(gameDelete);
        return convertGameToDto(gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce match n'existe pas ou a bien été supprimé !")));
    }

    public GameDto convertGameToDto(Game g) {
        return GameDto.builder()
                .idMatch(g.getIdMatch())
                .sidevic1(g.getSidevic1())
                .sidevic2(g.getSidevic2())
                .tie(g.getTie())
                .teams(g.getTeams().stream().map(this::convertTeamBetToDto).collect(Collectors.toList()))
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
