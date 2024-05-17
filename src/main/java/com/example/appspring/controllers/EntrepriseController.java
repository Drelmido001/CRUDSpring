package com.example.appspring.controllers;

import com.example.appspring.models.Entreprise;
import com.example.appspring.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/entreprises")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @GetMapping
    public List<Entreprise> getAllEntreprises() throws SQLException {
        return entrepriseService.getAllEntreprises();
    }

    @GetMapping("/{id}")
    public Entreprise getEntrepriseById(@PathVariable int id) throws SQLException {
        return entrepriseService.getEntrepriseById(id);
    }

    @PostMapping
    public void createEntreprise(@RequestBody Entreprise entreprise) throws SQLException {
        entrepriseService.createEntreprise(entreprise);
    }

    @PutMapping("/{id}")
    public void updateEntreprise(@PathVariable int id, @RequestBody Entreprise entreprise) throws SQLException {
        entreprise.setIdEntreprise(id);
        entrepriseService.updateEntreprise(entreprise);
    }

    @DeleteMapping("/{id}")
    public void deleteEntreprise(@PathVariable int id) throws SQLException {
        entrepriseService.deleteEntreprise(id);
    }
}
