package com.projet_paris_sportif.service;

import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGame() {
        return gameRepository.findAll();
    }

    public Game getGame(Integer id) {
        return gameRepository.getReferenceById(id);
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Game deleteGame(Integer id) {
        Game gameDelete = gameRepository.getReferenceById(id);
        gameRepository.delete(gameDelete);
        return gameDelete;
    }
}
