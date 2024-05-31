package com.projet_paris_sportif.mapper;

import com.projet_paris_sportif.dto.game.GameRequestDTO;
import com.projet_paris_sportif.dto.game.GameResponseDTO;
import com.projet_paris_sportif.dto.game.GameResultsDto;
import com.projet_paris_sportif.dto.game.GameTeamDto;
import com.projet_paris_sportif.model.Bet;
import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.model.Results;
import com.projet_paris_sportif.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(source = "idMatch", target = "idMatch")
    @Mapping(source = "teams", target = "teams")
    @Mapping(source = "sum", target = "sum")
    @Mapping(source = "result", target = "result")
    GameResponseDTO GameToGameResponseDTO(Game game);

    Game GameRequestDTOToGame(GameRequestDTO gameRequestDTO);

    List<GameTeamDto> teamsToGameTeamDtos(List<Team> teams);

    @Mapping(source = "idTeam", target = "idTeam")
    @Mapping(source = "teamname", target = "teamname")
    GameTeamDto teamToGameTeamDto(Team team);

    List<Bet> sumToBetDtos(List<Bet> sum);

    Bet betToBetDto(Bet bet);

    @Mapping(source = "idResult", target = "idResult")
    @Mapping(source = "resultVicTeam1", target = "resultVicTeam1")
    @Mapping(source = "resultVicTeam2", target = "resultVicTeam2")
    @Mapping(source = "resultTie", target = "resultTie")
    GameResultsDto resultsToGameResultsDto(Results result);

    Results gameResultsDtoToResults(GameResultsDto gameResultsDto);
}
