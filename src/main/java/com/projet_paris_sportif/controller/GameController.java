package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.dto.GameDto;
import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController extends Exception {

    @Autowired
    private GameService gameService;

    @GetMapping("/allGames")
    public List<GameDto> getAllGame() {
        return gameService.getAllGame();
    }

    @GetMapping("/game")
    public GameDto getGame(@RequestParam Integer id) throws ResourceNotFoundException {
        return gameService.getGame(id);
    }

    @PostMapping("/game")
    public GameDto createGame(@RequestBody Game game) {
        return gameService.createGame(game);
    }

    @DeleteMapping("/game")
    public GameDto deleteGame(@RequestParam Integer id) throws ResourceNotFoundException {
        return gameService.deleteGame(id);
    }
}
