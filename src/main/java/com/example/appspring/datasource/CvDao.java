package com.example.appspring.datasource;

import com.example.appspring.models.Cv;
import com.example.appspring.models.Competence;
import com.example.appspring.models.Entreprise;
import com.example.appspring.models.informationperso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CvDao {
    private Connection connection;

    public CvDao(Connection connection) {
        this.connection = connection;
    }

    public void createCv(Cv cv) throws SQLException {
        String insertCvSql = "INSERT INTO cv (profile, id_info) VALUES (?, ?)";
        try (PreparedStatement cvStatement = connection.prepareStatement(insertCvSql, Statement.RETURN_GENERATED_KEYS)) {
            cvStatement.setString(1, cv.getProfile());
            cvStatement.setInt(2, cv.getInformationPerso().getId_info());
            cvStatement.executeUpdate();

            try (ResultSet generatedKeys = cvStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int cvId = generatedKeys.getInt(1);
                    if (cv.getCompetences() != null) {
                        for (Competence competence : cv.getCompetences()) {
                            addCompetenceToCv(cvId, competence.getCompetanceId());
                        }
                    }
                    if (cv.getEntreprises() != null) {
                        for (Entreprise entreprise : cv.getEntreprises()) {
                            addEntrepriseToCv(cvId, entreprise.getIdEntreprise());
                        }
                    }
                } else {
                    throw new SQLException("Creating CV failed, no ID obtained.");
                }
            }
        }
    }

    public void addCompetenceToCv(int cvId, int competenceId) throws SQLException {
        String query = "INSERT INTO cv_competence (cv_id, competence_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cvId);
            statement.setInt(2, competenceId);
            statement.executeUpdate();
        }
    }

    public void addEntrepriseToCv(int cvId, int entrepriseId) throws SQLException {
        String query = "INSERT INTO cv_entreprise (cv_id, entreprise_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cvId);
            statement.setInt(2, entrepriseId);
            statement.executeUpdate();
        }
    }

    public Cv getById(int id) throws SQLException {
        String query = "SELECT c.id, c.profile, i.id_info, i.fullName, i.email " +
                "FROM cv c " +
                "INNER JOIN information_perso i ON c.id_info = i.id_info " +
                "WHERE c.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Cv cv = new Cv();
                    cv.setId(resultSet.getInt("id"));
                    cv.setProfile(resultSet.getString("profile"));

                    informationperso informationPerso = new informationperso();
                    informationPerso.setId_info(resultSet.getInt("id_info"));
                    informationPerso.setFullName(resultSet.getString("fullName"));
                    informationPerso.setEmail(resultSet.getString("email"));
                    cv.setInformationPerso(informationPerso);

                    cv.setCompetences(getCompetencesByCvId(cv.getId()));
                    cv.setEntreprises(getEntreprisesByCvId(cv.getId()));

                    return cv;
                }
            }
        }
        return null;
    }

    public List<Cv> getAll() throws SQLException {
        List<Cv> cvs = new ArrayList<>();
        String query = "SELECT c.id, c.profile, i.id_info, i.fullName, i.email " +
                "FROM cv c " +
                "INNER JOIN information_perso i ON c.id_info = i.id_info";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Cv cv = new Cv();
                cv.setId(resultSet.getInt("id"));
                cv.setProfile(resultSet.getString("profile"));

                informationperso informationPerso = new informationperso();
                informationPerso.setId_info(resultSet.getInt("id_info"));
                informationPerso.setFullName(resultSet.getString("fullName"));
                informationPerso.setEmail(resultSet.getString("email"));
                cv.setInformationPerso(informationPerso);

                cv.setCompetences(getCompetencesByCvId(cv.getId()));
                cv.setEntreprises(getEntreprisesByCvId(cv.getId()));

                cvs.add(cv);
            }
        }
        return cvs;
    }

    public void update(Cv cv) throws SQLException {
        String query = "UPDATE cv SET profile = ?, id_info = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cv.getProfile());
            statement.setInt(2, cv.getInformationPerso().getId_info());
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

    private List<Competence> getCompetencesByCvId(int cvId) throws SQLException {
        List<Competence> competences = new ArrayList<>();
        String query = "SELECT comp.competence_id, comp.competence_nom " +
                "FROM competence comp " +
                "INNER JOIN cv_competence cc ON comp.competence_id = cc.competence_id " +
                "WHERE cc.cv_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cvId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Competence competence = new Competence();
                    competence.setCompetanceId(resultSet.getInt("competence_id"));
                    competence.setCompetanceName(resultSet.getString("competence_nom"));
                    competences.add(competence);
                }
            }
        }
        return competences;
    }

    private List<Entreprise> getEntreprisesByCvId(int cvId) throws SQLException {
        List<Entreprise> entreprises = new ArrayList<>();
        String query = "SELECT ent.idEntreprise, ent.nom, ent.emailEntreprise " +
                "FROM entreprise ent " +
                "INNER JOIN cv_entreprise ce ON ent.idEntreprise = ce.entreprise_id " +
                "WHERE ce.cv_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cvId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Entreprise entreprise = new Entreprise();
                    entreprise.setIdEntreprise(resultSet.getInt("idEntreprise"));
                    entreprise.setNom(resultSet.getString("nom"));
                    entreprise.setEmailEntreprise(resultSet.getString("emailEntreprise"));
                    entreprises.add(entreprise);
                }
            }
        }
        return entreprises;
    }
}
