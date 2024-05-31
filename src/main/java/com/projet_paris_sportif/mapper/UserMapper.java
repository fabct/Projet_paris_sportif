package com.projet_paris_sportif.mapper;

import com.projet_paris_sportif.dto.user.UserBetDTO;
import com.projet_paris_sportif.dto.game.*;
import com.projet_paris_sportif.dto.user.UserResponseDTO;
import com.projet_paris_sportif.dto.user.UserRequestDTO;
import com.projet_paris_sportif.dto.user.UserBetGameDto;
import com.projet_paris_sportif.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userRequestDTOToUser(UserRequestDTO userRequestDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "bets", target = "bets")
    UserResponseDTO userToUserResponseDTO(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "match", target = "game")
    @Mapping(source = "sum", target = "sum")
    UserBetDTO betToUserBetDTO(Bet bet);

    @Mapping(source = "idMatch", target = "idMatch")
    @Mapping(source = "sidevic1", target = "sidevic1")
    @Mapping(source = "sidevic2", target = "sidevic2")
    @Mapping(source = "tie", target = "tie")
    @Mapping(source = "teams", target = "teams")
    @Mapping(source = "result", target = "result")
    UserBetGameDto gameToUserBetGameDto(Game game);

    @Mapping(source = "idTeam", target = "idTeam")
    @Mapping(source = "teamname", target = "teamname")
    GameTeamDto teamToGameTeamDto(Team team);

    @Mapping(source = "idResult", target = "idResult")
    @Mapping(source = "resultVicTeam1", target = "resultVicTeam1")
    @Mapping(source = "resultVicTeam2", target = "resultVicTeam2")
    @Mapping(source = "resultTie", target = "resultTie")
    GameResultsDto resultsToGameResultsDto(Results results);

    default List<UserBetDTO> mapBetsToUserBetDTOs(List<Bet> bets) {
        return bets.stream()
                .map(this::betToUserBetDTO)
                .collect(Collectors.toList());
    }

    default List<GameTeamDto> mapTeamsToGameTeamDtos(List<Team> teams) {
        return teams.stream()
                .map(this::teamToGameTeamDto)
                .collect(Collectors.toList());
    }
}


