package com.projet_paris_sportif.dto.game;

import java.util.List;

import com.projet_paris_sportif.model.Bet;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameResponseDTO{
    private Double sidevic1;
    private Double sidevic2;
    private Double tie;
    private Integer idMatch;
    private List<GameTeamDto> teams;
    private List<Bet> sum;
    private GameResultsDto result;
}
