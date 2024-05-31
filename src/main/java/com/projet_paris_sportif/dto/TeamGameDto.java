package com.projet_paris_sportif.dto;

import java.util.List;
import java.util.Set;

import com.projet_paris_sportif.model.Bet;
import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.model.Results;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamGameDto {
    private Integer idMatch;
    private Double sidevic1;
    private Double sidevic2;
    private Double tie;
    private List<Bet> sum;
    private Results result;
}
