package com.projet_paris_sportif.service;

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

    public Team deleteTeam(String id) {
        Team teamDeleted = teamRepository.getReferenceById(id);
        teamRepository.delete(teamDeleted);
        return teamDeleted;
    }

    public Team getTeam(String id) {
        return teamRepository.getReferenceById(id);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
