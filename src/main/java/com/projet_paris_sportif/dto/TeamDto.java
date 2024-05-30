package com.projet_paris_sportif.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDto {
    private Integer idTeam;
    private String teamname;
    private List<TeamGameDto> matchs;
}
