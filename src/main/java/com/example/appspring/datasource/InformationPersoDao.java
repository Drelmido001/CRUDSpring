package com.example.appspring.datasource;

import com.example.appspring.models.informationperso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformationPersoDao {
    private Connection connection;

    public InformationPersoDao(Connection connection) {
        this.connection = connection;
    }

    public void create(informationperso informationPerso) throws SQLException {
        String query = "INSERT INTO information_perso (fullname, email) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, informationPerso.getFullname());
            statement.setString(2, informationPerso.getEmail());
            statement.executeUpdate();
        }
    }

    public informationperso getById(int id) throws SQLException {
        String query = "SELECT * FROM information_perso WHERE id_info = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    informationperso informationPerso = new informationperso();
                    informationPerso.setId_info(resultSet.getInt("id_info"));
                    informationPerso.setFullname(resultSet.getString("fullname"));
                    informationPerso.setEmail(resultSet.getString("email"));
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
                informationPerso.setId_info(resultSet.getInt("id_info"));
                informationPerso.setFullname(resultSet.getString("fullname"));
                informationPerso.setEmail(resultSet.getString("email"));
                informationPersos.add(informationPerso);
            }
        }
        return informationPersos;
    }

    public void update(informationperso informationPerso) throws SQLException {
        String query = "UPDATE information_perso SET fullname = ?, email = ? WHERE id_info = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, informationPerso.getFullname());
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

