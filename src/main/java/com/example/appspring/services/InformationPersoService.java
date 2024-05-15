package com.example.appspring.services;

import com.example.appspring.datasource.InformationPersoDao;
import com.example.appspring.models.informationperso;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class InformationPersoService {
    private InformationPersoDao informationPersoDao;

    public InformationPersoService(Connection connection) {
        this.informationPersoDao = new InformationPersoDao(connection);
    }

    public void createInformationPerso(informationperso informationPerso) throws SQLException {
        informationPersoDao.create(informationPerso);
    }

    public informationperso getInformationPersoById(int id) throws SQLException {
        return informationPersoDao.getById(id);
    }

    public List<informationperso> getAllInformationPersos() throws SQLException {
        return informationPersoDao.getAll();
    }

    public void updateInformationPerso(informationperso informationPerso) throws SQLException {
        informationPersoDao.update(informationPerso);
    }

    public void deleteInformationPerso(int id) throws SQLException {
        informationPersoDao.delete(id);
    }
}
