package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.dto.result.ResultResponseDTO;
import com.projet_paris_sportif.dto.result.ResultResquestDTO;
import com.projet_paris_sportif.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ResultsController extends Exception {

    @Autowired
    private ResultsService resultsService;

    @GetMapping("/allResults")
    public List<ResultResponseDTO> getAllResults() {
        return resultsService.getAllResults();
    }

    @GetMapping("/results")
    public ResultResponseDTO getResults(@RequestParam Integer id) throws ResourceNotFoundException {
        return resultsService.getResult(id);
    }

    @PostMapping("/results")
    public ResultResponseDTO createResult(@RequestBody ResultResquestDTO results) {
        return resultsService.createResult(results);
    }

    @DeleteMapping("/results")
    public ResultResponseDTO deleteResults(@RequestParam Integer id) throws ResourceNotFoundException {
        return resultsService.deleteResult(id);
    }

}
