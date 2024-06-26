package com.projet_paris_sportif.dto.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameResultsDto {
    private Integer idResult;
    private Boolean resultVicTeam1;
    private Boolean resultVicTeam2;
    private Boolean resultTie;
}
