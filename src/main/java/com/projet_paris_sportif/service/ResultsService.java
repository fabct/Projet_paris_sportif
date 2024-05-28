package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.model.Results;
import com.projet_paris_sportif.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsService {
    @Autowired
    private ResultsRepository resultsRepository;

    public Results createResult(Results results) {
        return resultsRepository.save(results);
    }

    public Results getResult(Integer id) throws ResourceNotFoundException {
        return resultsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce résultat n'existe pas !"));
    }

    public List<Results> getAllResults() {
        return resultsRepository.findAll();
    }

    public Results deleteResult(Integer id) throws ResourceNotFoundException {
        Results resultDelete = resultsRepository.getReferenceById(id);
        resultsRepository.delete(resultDelete);
        return resultsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce résultat n'existe pas ou a bien été supprimé !"));
    }
}
