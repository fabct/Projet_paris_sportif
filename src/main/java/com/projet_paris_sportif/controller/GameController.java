package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController extends Exception{

    @Autowired
    private GameService gameService;

    @GetMapping("/allGames")
    public List<Game> getAllGame(){
        return gameService.getAllGame();
    }

    @GetMapping("/games")
    public Game getGame(@RequestParam Integer id){
        return gameService.getGame(id);
    }

    @PostMapping("/game")
    public Game createGame(@RequestBody Game game){
        return gameService.createGame(game);
    }

    @DeleteMapping("/game")
    public Game deleteGame(Integer id) throws ResourceNotFoundException {
        return gameService.deleteGame(id);
    }
}
