package com.projet_paris_sportif.dto.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultResponseDTO{
    private Integer idResult;
    private Boolean resultVicTeam1;
    private Boolean resultVicTeam2;
    private Boolean resultTie;
    private ResultsGameDto game;
}
