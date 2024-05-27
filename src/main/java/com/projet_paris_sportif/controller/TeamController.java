package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.model.Team;
import com.projet_paris_sportif.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    public TeamService teamService;

    @GetMapping("/allTeams")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/team")
    public Team getTeam(@RequestParam Integer id){
        return teamService.getTeam(id);
    }

    @PostMapping("/team")
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @DeleteMapping("/team")
    public Team deleteTeam(@RequestParam Integer id){
        return teamService.deleteTeam(id);
    }
}
