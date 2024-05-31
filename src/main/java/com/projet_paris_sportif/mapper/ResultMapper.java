package com.projet_paris_sportif.mapper;

import com.projet_paris_sportif.dto.result.ResultResponseDTO;
import com.projet_paris_sportif.dto.result.ResultResquestDTO;
import com.projet_paris_sportif.model.Results;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResultMapper {

    Results ResultResquestDTOToResults(ResultResquestDTO resultResquestDTO);

    ResultResponseDTO ResultToResultResponseDTO(Results response);
}
