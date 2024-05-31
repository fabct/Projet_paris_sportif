package com.projet_paris_sportif.mapper;

import com.projet_paris_sportif.dto.team.TeamRequestDTO;
import com.projet_paris_sportif.dto.team.TeamResponseDTO;
import com.projet_paris_sportif.model.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    Team TeamRequestDTOToTeam(TeamRequestDTO teamRequestDTO);

    TeamResponseDTO TeamToTeamResponseDTO(Team response);
}
