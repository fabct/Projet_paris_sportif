package com.projet_paris_sportif.dto.result;

import java.util.List;

import com.projet_paris_sportif.dto.game.GameTeamDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultsGameDto {
    private Integer idMatch;
    private Double sidevic1;
    private Double sidevic2;
    private Double tie;
    private List<GameTeamDto> teams;
    private List<ResultsGameBetDto> sum;
}
