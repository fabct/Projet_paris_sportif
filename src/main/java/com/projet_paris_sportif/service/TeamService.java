package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.dto.team.TeamRequestDTO;
import com.projet_paris_sportif.dto.team.TeamResponseDTO;
import com.projet_paris_sportif.mapper.TeamMapper;
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

    @Autowired
    private TeamMapper teamMapper;

    public TeamResponseDTO createTeam(TeamRequestDTO teamRequestDTO) {
        final Team team = teamMapper.TeamRequestDTOToTeam(teamRequestDTO);
        final Team response = teamRepository.save(team);
        return teamMapper.TeamToTeamResponseDTO(response);
    }

    public TeamResponseDTO deleteTeam(Integer id) throws ResourceNotFoundException {
        Team teamDeleted = teamRepository.getReferenceById(id);
        teamRepository.delete(teamDeleted);
        return teamMapper.TeamToTeamResponseDTO(teamRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Cette équipe n'existe pas ou a bien été supprimée !")));
    }

    public TeamResponseDTO getTeam(Integer id) throws ResourceNotFoundException {
        final Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cette équipe n'existe pas !"));
        return teamMapper.TeamToTeamResponseDTO(team);
    }

    public List<TeamResponseDTO> getAllTeams() {
        final List<Team> teams = teamRepository.findAll();
        return teams.stream().map(teamMapper::TeamToTeamResponseDTO).collect(Collectors.toList());
    }
}
