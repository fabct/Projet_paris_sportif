package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.dto.result.ResultResponseDTO;
import com.projet_paris_sportif.dto.result.ResultResquestDTO;
import com.projet_paris_sportif.mapper.ResultMapper;
import com.projet_paris_sportif.model.Results;
import com.projet_paris_sportif.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultsService {
    @Autowired
    private ResultsRepository resultsRepository;

    @Autowired
    private ResultMapper resultMapper;

    public ResultResponseDTO createResult(ResultResquestDTO resultResquestDTO) {
        final Results results = resultMapper.ResultResquestDTOToResults(resultResquestDTO);
        final Results response = resultsRepository.save(results);
        return resultMapper.ResultToResultResponseDTO(response);
    }

    public ResultResponseDTO getResult(Integer id) throws ResourceNotFoundException {
        final Results results = resultsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce résultat n'existe pas !"));
        return resultMapper.ResultToResultResponseDTO(results);
    }

    public List<ResultResponseDTO> getAllResults() {
        final List<Results> results =resultsRepository.findAll();
        return results.stream().map(resultMapper::ResultToResultResponseDTO).collect(Collectors.toList());
    }

    public ResultResponseDTO deleteResult(Integer id) throws ResourceNotFoundException {
        Results resultDelete = resultsRepository.getReferenceById(id);
        resultsRepository.delete(resultDelete);
        return resultMapper.ResultToResultResponseDTO(resultsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce résultat n'existe pas ou a bien été supprimé !")));
    }
}
