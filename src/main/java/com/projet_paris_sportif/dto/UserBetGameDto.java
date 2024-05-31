package com.projet_paris_sportif.dto;

import java.util.List;

import com.projet_paris_sportif.dto.game.GameResultsDto;
import com.projet_paris_sportif.dto.game.GameTeamDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBetGameDto {
    private Integer idMatch;
    private Double sidevic1;
    private Double sidevic2;
    private Double tie;
    private List<GameTeamDto> teams;
    private GameResultsDto result;
}
