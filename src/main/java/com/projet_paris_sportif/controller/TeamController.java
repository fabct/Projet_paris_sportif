package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.dto.CreateTeamDto;
import com.projet_paris_sportif.dto.GetTeamDto;
import com.projet_paris_sportif.model.Team;
import com.projet_paris_sportif.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TeamController extends Exception {

    @Autowired
    public TeamService teamService;

    @GetMapping("/allTeams")
    public List<GetTeamDto> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/team")
    public GetTeamDto getTeam(@RequestParam Integer id) throws ResourceNotFoundException {
        return teamService.getTeam(id);
    }

    @PostMapping("/team")
    public CreateTeamDto createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @DeleteMapping("/team")
    public GetTeamDto deleteTeam(@RequestParam Integer id) throws ResourceNotFoundException {
        return teamService.deleteTeam(id);
    }
}
