package com.projet_paris_sportif.dto.game;

import com.projet_paris_sportif.model.Team;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GameRequestDTO {
    private Double sidevic1;
    private Double sidevic2;
    private Double tie;
    private List<Team> teams;
}
