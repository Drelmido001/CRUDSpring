package com.example.appspring.repository;

import com.example.appspring.services.CompetenceService;
import com.example.appspring.services.CvService;
import com.example.appspring.services.EntrepriseService;
import com.example.appspring.services.InformationPersoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class repository {
    private Connection connection;

    public repository(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public CvService getCvService() {
        return new CvService(connection);
    }

    public InformationPersoService getInformationPersoService() {
        return new InformationPersoService(connection);
    }

    public EntrepriseService getEntrepriseService() {
        return new EntrepriseService(connection);
    }

    public CompetenceService getCompetenceService() {
        return new CompetenceService(connection);
    }
}

