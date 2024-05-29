package com.example.appspring.controllers;

import com.example.appspring.models.Competence;
import com.example.appspring.services.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/competences")
public class CompetenceController {

    private final CompetenceService competenceService;

    @Autowired
    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @GetMapping
    public List<Competence> getAllCompetences() throws SQLException {
        System.out.println("salam");

        return competenceService.getAllCompetences();
    }

    @GetMapping("/{id}")
    public Competence getCompetenceById(@PathVariable int id) throws SQLException {
        return competenceService.getCompetenceById(id);
    }

    @PostMapping
    public void createCompetence(@RequestBody Competence competence) throws SQLException {
        competenceService.createCompetence(competence);
    }

    @PutMapping("/{id}")
    public void updateCompetence(@PathVariable int id, @RequestBody Competence competence) throws SQLException {
        competence.setCompetanceId(id);
        competenceService.updateCompetence(competence);
    }

    @DeleteMapping("/{id}")
    public void deleteCompetence(@PathVariable int id) throws SQLException {
        competenceService.deleteCompetence(id);
    }
}
