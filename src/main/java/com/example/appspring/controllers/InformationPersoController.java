package com.example.appspring.controllers;

import com.example.appspring.models.informationperso;
import com.example.appspring.services.InformationPersoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/informationpersos")
public class InformationPersoController {

    private final InformationPersoService informationPersoService;

    @Autowired
    public InformationPersoController(InformationPersoService informationPersoService) {
        this.informationPersoService = informationPersoService;
    }

    @GetMapping
    public List<informationperso> getAllInformationPersos() throws SQLException {
        return informationPersoService.getAllInformationPersos();
    }

    @GetMapping("/{id}")
    public informationperso getInformationPersoById(@PathVariable int id) throws SQLException {
        return informationPersoService.getInformationPersoById(id);
    }

    @PostMapping
    public void createInformationPerso(@RequestBody informationperso informationPerso) throws SQLException {
        informationPersoService.createInformationPerso(informationPerso);
    }

    @PutMapping("/{id}")
    public void updateInformationPerso(@PathVariable int id, @RequestBody informationperso informationPerso) throws SQLException {
        informationPerso.setId_info(id);
        informationPersoService.updateInformationPerso(informationPerso);
    }

    @DeleteMapping("/{id}")
    public void deleteInformationPerso(@PathVariable int id) throws SQLException {
        informationPersoService.deleteInformationPerso(id);
    }
}
