package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.dto.team.TeamRequestDTO;
import com.projet_paris_sportif.dto.team.TeamResponseDTO;
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
    public List<TeamResponseDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/team")
    public TeamResponseDTO getTeam(@RequestParam Integer id) throws ResourceNotFoundException {
        return teamService.getTeam(id);
    }

    @PostMapping("/team")
    public TeamResponseDTO createTeam(@RequestBody TeamRequestDTO team) {
        return teamService.createTeam(team);
    }

    @DeleteMapping("/team")
    public TeamResponseDTO deleteTeam(@RequestParam Integer id) throws ResourceNotFoundException {
        return teamService.deleteTeam(id);
    }
}
