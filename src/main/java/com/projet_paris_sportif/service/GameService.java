package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
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

    public Game getGame(Integer id) throws ResourceNotFoundException {
        return gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce match n'existe pas !"));
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Game deleteGame(Integer id) throws ResourceNotFoundException {
        Game gameDelete = gameRepository.getReferenceById(id);
        gameRepository.delete(gameDelete);
        return gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce match n'existe pas ou a bien été supprimé !"));
    }
}
