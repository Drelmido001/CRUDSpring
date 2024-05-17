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
        String query = "INSERT INTO competence (competence_nom) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, competence.getCompetanceName());
            statement.executeUpdate();
        }
    }

    public Competence getById(int id) throws SQLException {
        String query = "SELECT * FROM competence WHERE competence_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Competence competence = new Competence();
                    competence.setCompetanceId(resultSet.getInt(1));
                    competence.setCompetanceName(resultSet.getString(2));
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
                competence.setCompetanceId(resultSet.getInt(1));
                competence.setCompetanceName(resultSet.getString(2));
                competences.add(competence);
            }
        }
        return competences;
    }

    public void update(Competence competence) throws SQLException {
        String query = "UPDATE competence SET competence_nom = ? WHERE competence_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, competence.getCompetanceName());
            statement.setInt(2, competence.getCompetanceId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String deleteReferencesQuery = "DELETE FROM cv_competence WHERE competence_id = ?";
        try (PreparedStatement deleteReferencesStatement = connection.prepareStatement(deleteReferencesQuery)) {
            deleteReferencesStatement.setInt(1, id);
            deleteReferencesStatement.executeUpdate();
        }

        String deleteCompetenceQuery = "DELETE FROM competence WHERE competence_id = ?";
        try (PreparedStatement deleteCompetenceStatement = connection.prepareStatement(deleteCompetenceQuery)) {
            deleteCompetenceStatement.setInt(1, id);
            deleteCompetenceStatement.executeUpdate();
        }
    }

}
