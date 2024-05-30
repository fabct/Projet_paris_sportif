package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.dto.TeamDto;
import com.projet_paris_sportif.model.Team;
import com.projet_paris_sportif.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController extends Exception {

    @Autowired
    public TeamService teamService;

    @GetMapping("/allTeams")
    public List<TeamDto> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/team")
    public TeamDto getTeam(@RequestParam Integer id) throws ResourceNotFoundException {
        return teamService.getTeam(id);
    }

    @PostMapping("/team")
    public TeamDto createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @DeleteMapping("/team")
    public TeamDto deleteTeam(@RequestParam Integer id) throws ResourceNotFoundException {
        return teamService.deleteTeam(id);
    }
}
