package com.projet_paris_sportif.dto.user;

import com.projet_paris_sportif.dto.game.GameResultsDto;
import com.projet_paris_sportif.dto.game.GameTeamDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserBetGameDto {
    private Integer idMatch;
    private Double sidevic1;
    private Double sidevic2;
    private Double tie;
    private List<GameTeamDto> teams;
    private GameResultsDto result;
}
