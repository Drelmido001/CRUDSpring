package com.example.appspring.datasource;

import com.example.appspring.models.Competence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompetenceDao {
    private Connection connection;

    public CompetenceDao(Connection connection) {
        this.connection = connection;
    }

    public void create(Competence competence) throws SQLException {
        String query = "INSERT INTO competence (competanceName) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, competence.getCompetanceName());
            statement.executeUpdate();
        }
    }

    public Competence getById(int id) throws SQLException {
        String query = "SELECT * FROM competence WHERE competanceId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Competence competence = new Competence();
                    competence.setCompetanceId(resultSet.getInt("competanceId"));
                    competence.setCompetanceName(resultSet.getString("competanceName"));
                    return competence;
                }
            }
        }
        return null;
    }

    public List<Competence> getAll() throws SQLException {
        List<Competence> competences = new ArrayList<>();
        String query = "SELECT * FROM competence";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Competence competence = new Competence();
                competence.setCompetanceId(resultSet.getInt("competanceId"));
                competence.setCompetanceName(resultSet.getString("competanceName"));
                competences.add(competence);
            }
        }
        return competences;
    }

    public void update(Competence competence) throws SQLException {
        String query = "UPDATE competence SET competanceName = ? WHERE competanceId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, competence.getCompetanceName());
            statement.setInt(2, competence.getCompetanceId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM competence WHERE competanceId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

