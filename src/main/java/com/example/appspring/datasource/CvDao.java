package com.example.appspring.datasource;

import com.example.appspring.models.Cv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CvDao {
    private Connection connection;

    public CvDao(Connection connection) {
        this.connection = connection;
    }

    public void create(Cv cv) throws SQLException {
        String query = "INSERT INTO cv (profile, id_info) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cv.getProfile());
            statement.setInt(2, cv.getId_info());
            statement.executeUpdate();
        }
    }

    public Cv getById(int id) throws SQLException {
        String query = "SELECT * FROM cv WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Cv cv = new Cv();
                    cv.setId(resultSet.getInt("id"));
                    cv.setProfile(resultSet.getString("profile"));
                    cv.setId_info(resultSet.getInt("id_info"));
                    return cv;
                }
            }
        }
        return null;
    }

    public List<Cv> getAll() throws SQLException {
        List<Cv> cvs = new ArrayList<>();
        String query = "SELECT * FROM cv";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Cv cv = new Cv();
                cv.setId(resultSet.getInt("id"));
                cv.setProfile(resultSet.getString("profile"));
                cv.setId_info(resultSet.getInt("id_info"));
                cvs.add(cv);
            }
        }
        return cvs;
    }

    public void update(Cv cv) throws SQLException {
        String query = "UPDATE cv SET profile = ?, id_info = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cv.getProfile());
            statement.setInt(2, cv.getId_info());
            statement.setInt(3, cv.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM cv WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
