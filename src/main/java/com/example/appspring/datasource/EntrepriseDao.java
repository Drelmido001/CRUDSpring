package com.example.appspring.datasource;

import com.example.appspring.models.Entreprise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntrepriseDao {
    private Connection connection;

    public EntrepriseDao(Connection connection) {
        this.connection = connection;
    }

    public void create(Entreprise entreprise) throws SQLException {
        String query = "INSERT INTO entreprise (nom, emailEntreprise) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, entreprise.getNom());
            statement.setString(2, entreprise.getEmailEntreprise());
            statement.executeUpdate();
        }
    }

    public Entreprise getById(int id) throws SQLException {
        String query = "SELECT * FROM entreprise WHERE idEntreprise = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Entreprise entreprise = new Entreprise();
                    entreprise.setIdEntreprise(resultSet.getInt("idEntreprise"));
                    entreprise.setNom(resultSet.getString("nom"));
                    entreprise.setEmailEntreprise(resultSet.getString("emailEntreprise"));
                    return entreprise;
                }
            }
        }
        return null;
    }

    public List<Entreprise> getAll() throws SQLException {
        List<Entreprise> entreprises = new ArrayList<>();
        String query = "SELECT * FROM entreprise";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Entreprise entreprise = new Entreprise();
                entreprise.setIdEntreprise(resultSet.getInt("idEntreprise"));
                entreprise.setNom(resultSet.getString("nom"));
                entreprise.setEmailEntreprise(resultSet.getString("emailEntreprise"));
                entreprises.add(entreprise);
            }
        }
        return entreprises;
    }

    public void update(Entreprise entreprise) throws SQLException {
        String query = "UPDATE entreprise SET nom = ?, emailEntreprise = ? WHERE idEntreprise = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, entreprise.getNom());
            statement.setString(2, entreprise.getEmailEntreprise());
            statement.setInt(3, entreprise.getIdEntreprise());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM entreprise WHERE idEntreprise = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

