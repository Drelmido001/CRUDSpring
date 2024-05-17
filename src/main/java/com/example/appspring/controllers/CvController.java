package com.example.appspring.controllers;

import com.example.appspring.models.Cv;
import com.example.appspring.services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvController {

    private final CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping
    public List<Cv> getAllCvs() throws SQLException {
        return cvService.getAllCvs();
    }

    @GetMapping("/{id}")
    public Cv getCvById(@PathVariable int id) throws SQLException {
        return cvService.getCvById(id);
    }

    @PostMapping
    public void createCv(@RequestBody Cv cv) throws SQLException {
        cvService.createCv(cv);
    }

    @PutMapping("/{id}")
    public void updateCv(@PathVariable int id, @RequestBody Cv cv) throws SQLException {
        cv.setId(id);
        cvService.updateCv(cv);
    }

    @DeleteMapping("/{id}")
    public void deleteCv(@PathVariable int id) throws SQLException {
        cvService.deleteCv(id);
    }
}
