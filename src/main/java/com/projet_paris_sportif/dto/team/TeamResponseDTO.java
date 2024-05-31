package com.projet_paris_sportif.dto.team;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TeamResponseDTO extends TeamRequestDTO{
    private Integer idTeam;
    private List<TeamGameDto> match;
}
