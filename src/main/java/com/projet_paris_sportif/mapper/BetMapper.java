package com.projet_paris_sportif.mapper;

import com.projet_paris_sportif.dto.bet.BetResponseDTO;
import com.projet_paris_sportif.dto.game.*;
import com.projet_paris_sportif.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BetMapper {

    BetMapper INSTANCE = Mappers.getMapper(BetMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "match", target = "game")
    @Mapping(source = "sum", target = "sum")
    BetResponseDTO BetToBetResponseDTO(Bet bet);

    @Mapping(source = "idMatch", target = "idMatch")
    @Mapping(source = "sidevic1", target = "sidevic1")
    @Mapping(source = "sidevic2", target = "sidevic2")
    @Mapping(source = "tie", target = "tie")
    @Mapping(source = "teams", target = "teams")
    @Mapping(source = "result", target = "result")
    GameResponseDTO GameToGameResponseDTO(Game game);

    @Mapping(source = "idTeam", target = "idTeam")
    @Mapping(source = "teamname", target = "teamname")
    GameTeamDto TeamToGameTeamDto(Team team);

    @Mapping(source = "idResult", target = "idResult")
    @Mapping(source = "resultVicTeam1", target = "resultVicTeam1")
    @Mapping(source = "resultVicTeam2", target = "resultVicTeam2")
    @Mapping(source = "resultTie", target = "resultTie")
    GameResultsDto ResultsToGameResultsDto(Results results);

    default List<GameTeamDto> mapTeamsToGameTeamDtos(List<Team> teams) {
        return teams.stream()
                .map(this::TeamToGameTeamDto)
                .collect(Collectors.toList());
    }

    default List<BetResponseDTO> mapBetsToBetResponseDtos(List<Bet> bets) {
        return bets.stream()
                .map(this::BetToBetResponseDTO)
                .collect(Collectors.toList());
    }
}
