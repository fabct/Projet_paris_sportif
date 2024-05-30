package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.dto.CreateTeamDto;
import com.projet_paris_sportif.dto.GetTeamDto;
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

    public CreateTeamDto createTeam(Team team) {
        return convertCreateTeamToDto(teamRepository.save(team));
    }

    public GetTeamDto deleteTeam(Integer id) throws ResourceNotFoundException {
        Team teamDeleted = teamRepository.getReferenceById(id);
        teamRepository.delete(teamDeleted);
        return convertGetTeamToDto(teamRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Cette équipe n'existe pas ou a bien été supprimée !")));
    }

    public GetTeamDto getTeam(Integer id) throws ResourceNotFoundException {
        return convertGetTeamToDto(teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cette équipe n'existe pas !")));
    }

    public List<GetTeamDto> getAllTeams() {
        return teamRepository.findAll().stream().map(this::convertGetTeamToDto).collect(Collectors.toList());
    }

    public CreateTeamDto convertCreateTeamToDto(Team t) {
        return CreateTeamDto.builder()
                .idTeam(t.getIdTeam())
                .teamname(t.getTeamname())
                .build();
    }

    public GetTeamDto convertGetTeamToDto(Team t) {
        return GetTeamDto.builder()
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
