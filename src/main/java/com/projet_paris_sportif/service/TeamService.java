package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.dto.TeamDto;
import com.projet_paris_sportif.dto.TeamGameDto;
import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.model.Team;
import com.projet_paris_sportif.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public TeamDto createTeam(Team team) {
        return convertTeamToDto(teamRepository.save(team));
    }

    public TeamDto deleteTeam(Integer id) throws ResourceNotFoundException {
        Team teamDeleted = teamRepository.getReferenceById(id);
        teamRepository.delete(teamDeleted);
        return convertTeamToDto(teamRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Cette équipe n'existe pas ou a bien été supprimée !")));
    }

    public TeamDto getTeam(Integer id) throws ResourceNotFoundException {
        return convertTeamToDto(teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cette équipe n'existe pas !")));
    }

    public List<TeamDto> getAllTeams() {
        return teamRepository.findAll().stream().map(this::convertTeamToDto).collect(Collectors.toList());
    }

    public TeamDto convertTeamToDto(Team t) {
        return TeamDto.builder()
                .idTeam(t.getIdTeam())
                .teamname(t.getTeamname())
                .matchs(t.getMatchs().stream().map(this::convertTeamGameToDto).collect(Collectors.toList()))
                .build();
    }

    public TeamGameDto convertTeamGameToDto(Game g) {
        return TeamGameDto.builder()
                .idMatch(g.getIdMatch())
                .sidevic1(g.getSidevic1())
                .sidevic2(g.getSidevic2())
                .tie(g.getTie())
                .sum(g.getSum())
                .result(g.getResult())
                .build();
    }
}
