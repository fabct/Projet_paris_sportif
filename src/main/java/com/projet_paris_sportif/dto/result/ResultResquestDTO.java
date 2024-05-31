package com.projet_paris_sportif.dto.result;

import com.projet_paris_sportif.model.Game;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultResquestDTO {
    private Boolean resultVicTeam1;
    private Boolean resultVicTeam2;
    private Boolean resultTie;
    private Game game;
}
