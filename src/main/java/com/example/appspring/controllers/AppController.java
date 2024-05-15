package com.example.appspring.controllers;

import com.example.appspring.models.Competence;
import com.example.appspring.models.Cv;
import com.example.appspring.models.Entreprise;
import com.example.appspring.models.informationperso;
import com.example.appspring.services.CompetenceService;
import com.example.appspring.services.CvService;
import com.example.appspring.services.EntrepriseService;
import com.example.appspring.services.InformationPersoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    private final CvService cvService;
    private final InformationPersoService informationPersoService;
    private final EntrepriseService entrepriseService;
    private final CompetenceService competenceService;

    @Autowired
    public AppController(CvService cvService, InformationPersoService informationPersoService,
                         EntrepriseService entrepriseService, CompetenceService competenceService) {
        this.cvService = cvService;
        this.informationPersoService = informationPersoService;
        this.entrepriseService = entrepriseService;
        this.competenceService = competenceService;
    }

    @GetMapping("/cvs")
    public List<Cv> getAllCvs() throws SQLException {
        return cvService.getAllCvs();
    }

    @GetMapping("/cv/{id}")
    public Cv getCvById(@PathVariable int id) throws SQLException {
        return cvService.getCvById(id);
    }

    @PostMapping("/cv")
    public void createCv(@RequestBody Cv cv) throws SQLException {
        cvService.createCv(cv);
    }

    @PutMapping("/cv/{id}")
    public void updateCv(@PathVariable int id, @RequestBody Cv cv) throws SQLException {
        cv.setId(id);
        cvService.updateCv(cv);
    }

    @DeleteMapping("/cv/{id}")
    public void deleteCv(@PathVariable int id) throws SQLException {
        cvService.deleteCv(id);
    }

    @GetMapping("/informationpersos")
    public List<informationperso> getAllInformationPersos() throws SQLException {
        return informationPersoService.getAllInformationPersos();
    }

    @GetMapping("/informationperso/{id}")
    public informationperso getInformationPersoById(@PathVariable int id) throws SQLException {
        return informationPersoService.getInformationPersoById(id);
    }

    @PostMapping("/informationperso")
    public void createInformationPerso(@RequestBody informationperso informationPerso) throws SQLException {
        informationPersoService.createInformationPerso(informationPerso);
    }

    @PutMapping("/informationperso/{id}")
    public void updateInformationPerso(@PathVariable int id, @RequestBody informationperso informationPerso) throws SQLException {
        informationPerso.setId_info(id);
        informationPersoService.updateInformationPerso(informationPerso);
    }

    @DeleteMapping("/informationperso/{id}")
    public void deleteInformationPerso(@PathVariable int id) throws SQLException {
        informationPersoService.deleteInformationPerso(id);
    }

    @GetMapping("/entreprises")
    public List<Entreprise> getAllEntreprises() throws SQLException {
        return entrepriseService.getAllEntreprises();
    }

    @GetMapping("/entreprise/{id}")
    public Entreprise getEntrepriseById(@PathVariable int id) throws SQLException {
        return entrepriseService.getEntrepriseById(id);
    }

    @PostMapping("/entreprise")
    public void createEntreprise(@RequestBody Entreprise entreprise) throws SQLException {
        entrepriseService.createEntreprise(entreprise);
    }

    @PutMapping("/entreprise/{id}")
    public void updateEntreprise(@PathVariable int id, @RequestBody Entreprise entreprise) throws SQLException {
        entreprise.setIdEntreprise(id);
        entrepriseService.updateEntreprise(entreprise);
    }

    @DeleteMapping("/entreprise/{id}")
    public void deleteEntreprise(@PathVariable int id) throws SQLException {
        entrepriseService.deleteEntreprise(id);
    }

    @GetMapping("/competences")
    public List<Competence> getAllCompetences() throws SQLException {
        return competenceService.getAllCompetences();
    }

    @GetMapping("/competence/{id}")
    public Competence getCompetenceById(@PathVariable int id) throws SQLException {
        return competenceService.getCompetenceById(id);
    }

    @PostMapping("/competence")
    public void createCompetence(@RequestBody Competence competence) throws SQLException {
        competenceService.createCompetence(competence);
    }

    @PutMapping("/competence/{id}")
    public void updateCompetence(@PathVariable int id, @RequestBody Competence competence) throws SQLException {
        competence.setCompetanceId(id);
        competenceService.updateCompetence(competence);
    }

    @DeleteMapping("/competence/{id}")
    public void deleteCompetence(@PathVariable int id) throws SQLException {
        competenceService.deleteCompetence(id);
    }
}
