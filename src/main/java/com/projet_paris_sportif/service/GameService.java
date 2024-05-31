package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.dto.game.GameRequestDTO;
import com.projet_paris_sportif.dto.game.GameResponseDTO;
import com.projet_paris_sportif.dto.game.GameResultsDto;
import com.projet_paris_sportif.dto.game.GameTeamDto;
import com.projet_paris_sportif.mapper.GameMapper;
import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.model.Results;
import com.projet_paris_sportif.model.Team;
import com.projet_paris_sportif.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameMapper gameMapper;

    public List<GameResponseDTO> getAllGame() {
        return gameRepository.findAll().stream()
                .map(gameMapper::GameToGameResponseDTO)
                .collect(Collectors.toList());
    }

    public GameResponseDTO getGame(Integer id) throws ResourceNotFoundException {
        return gameMapper.GameToGameResponseDTO(gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce match n'existe pas !")));
    }

    public GameResponseDTO createGame(GameRequestDTO gameRequestDTO) {
        final Game game = gameMapper.GameRequestDTOToGame(gameRequestDTO);
        final Game response = gameRepository.save(game);
        return gameMapper.GameToGameResponseDTO(response);
    }

    public GameResponseDTO deleteGame(Integer id) throws ResourceNotFoundException {
        Game gameDelete = gameRepository.getReferenceById(id);
        gameRepository.delete(gameDelete);
        return gameMapper.GameToGameResponseDTO(gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce match n'existe pas ou a bien été supprimé !")));
    }
}
