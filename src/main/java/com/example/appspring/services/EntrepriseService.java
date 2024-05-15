package com.example.appspring.services;

import com.example.appspring.datasource.EntrepriseDao;
import com.example.appspring.models.Entreprise;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@Service
public class EntrepriseService {
    private EntrepriseDao entrepriseDao;

    public EntrepriseService(Connection connection) {
        this.entrepriseDao = new EntrepriseDao(connection);
    }

    public void createEntreprise(Entreprise entreprise) throws SQLException {
        entrepriseDao.create(entreprise);
    }

    public Entreprise getEntrepriseById(int id) throws SQLException {
        return entrepriseDao.getById(id);
    }

    public List<Entreprise> getAllEntreprises() throws SQLException {
        return entrepriseDao.getAll();
    }

    public void updateEntreprise(Entreprise entreprise) throws SQLException {
        entrepriseDao.update(entreprise);
    }

    public void deleteEntreprise(int id) throws SQLException {
        entrepriseDao.delete(id);
    }
}

