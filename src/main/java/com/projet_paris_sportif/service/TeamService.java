package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.model.Team;
import com.projet_paris_sportif.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team deleteTeam(Integer id) throws ResourceNotFoundException {
        Team teamDeleted = teamRepository.getReferenceById(id);
        teamRepository.delete(teamDeleted);
        return teamRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Cette équipe n'existe pas ou a bien été supprimée !"));
    }

    public Team getTeam(Integer id) throws ResourceNotFoundException {
        return teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cette équipe n'existe pas !"));
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
