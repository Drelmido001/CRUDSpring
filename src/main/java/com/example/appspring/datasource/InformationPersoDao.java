package com.example.appspring.datasource;

import com.example.appspring.models.informationperso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InformationPersoDao {
    private Connection connection;

        public InformationPersoDao(Connection connection) {
        this.connection = connection;
    }

    public int createWithAllAttributes(informationperso informationPerso) throws SQLException {
        String query = "INSERT INTO information_perso (id_info, fullName, email) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, informationPerso.getId_info());
            statement.setString(2, informationPerso.getFullName());
            statement.setString(3, informationPerso.getEmail());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Creating InformationPerso failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating InformationPerso failed, no ID obtained.");
                }
            }
        }
    }

    public informationperso getById(int id) throws SQLException {
        String query = "SELECT * FROM information_perso WHERE id_info = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    informationperso informationPerso = new informationperso();
                    informationPerso.setId_info(resultSet.getInt(1));
                    informationPerso.setFullName(resultSet.getString(2));
                    informationPerso.setEmail(resultSet.getString(3));
                    return informationPerso;
                }
            }
        }
        return null;
    }

    public List<informationperso> getAll() throws SQLException {
        List<informationperso> informationPersos = new ArrayList<>();
        String query = "SELECT * FROM information_perso";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                informationperso informationPerso = new informationperso();
                informationPerso.setId_info(resultSet.getInt(1));
                informationPerso.setFullName(resultSet.getString(2));
                informationPerso.setEmail(resultSet.getString(3));
                informationPersos.add(informationPerso);
            }
        }
        return informationPersos;
    }

    public void update(informationperso informationPerso) throws SQLException {
        String query = "UPDATE information_perso SET fullName = ?, email = ? WHERE id_info = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, informationPerso.getFullName());
            statement.setString(2, informationPerso.getEmail());
            statement.setInt(3, informationPerso.getId_info());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM information_perso WHERE id_info = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
