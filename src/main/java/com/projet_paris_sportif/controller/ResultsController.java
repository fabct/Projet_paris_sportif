package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.dto.ResultsDto;
import com.projet_paris_sportif.model.Results;
import com.projet_paris_sportif.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultsController extends Exception {

    @Autowired
    private ResultsService resultsService;

    @GetMapping("/allResults")
    public List<ResultsDto> getAllResults() {
        return resultsService.getAllResults();
    }

    @GetMapping("/results")
    public ResultsDto getResults(@RequestParam Integer id) throws ResourceNotFoundException {
        return resultsService.getResult(id);
    }

    @PostMapping("/results")
    public ResultsDto createResult(@RequestBody Results results) {
        return resultsService.createResult(results);
    }

    @DeleteMapping("/results")
    public ResultsDto deleteResults(@RequestParam Integer id) throws ResourceNotFoundException {
        return resultsService.deleteResult(id);
    }

}
