package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.dto.game.GameRequestDTO;
import com.projet_paris_sportif.dto.game.GameResponseDTO;
import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class GameController extends Exception {

    @Autowired
    private GameService gameService;

    @GetMapping("/allGames")
    public List<GameResponseDTO> getAllGame() {
        return gameService.getAllGame();
    }

    @GetMapping("/game")
    public GameResponseDTO getGame(@RequestParam Integer id) throws ResourceNotFoundException {
        return gameService.getGame(id);
    }

    @PostMapping("/game")
    public GameResponseDTO createGame(@RequestBody GameRequestDTO game) {
        return gameService.createGame(game);
    }

    @DeleteMapping("/game")
    public GameResponseDTO deleteGame(@RequestParam Integer id) throws ResourceNotFoundException {
        return gameService.deleteGame(id);
    }
}
