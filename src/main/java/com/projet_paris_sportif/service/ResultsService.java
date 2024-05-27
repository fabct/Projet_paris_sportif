package com.projet_paris_sportif.service;

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

    public Results getResult(String id) {
        return resultsRepository.getReferenceById(id);
    }

    public List<Results> getAllResults() {
        return resultsRepository.findAll();
    }

    public Results deleteResult(String id) {

        Results resultsDeleted = resultsRepository.getReferenceById(id);
        resultsRepository.deleteById(id);
        return resultsDeleted;
    }
}
