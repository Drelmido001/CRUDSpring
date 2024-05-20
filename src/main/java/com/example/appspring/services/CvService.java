package com.example.appspring.services;

import com.example.appspring.datasource.CvDao;
import com.example.appspring.models.Cv;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class CvService {
    private CvDao cvDao;

        public CvService(Connection connection) {
            this.cvDao = new CvDao(connection);
        }


    public void createCv(Cv cv) throws SQLException {
        cvDao.createCv(cv);
    }

    public Cv getCvById(int id) throws SQLException {
        return cvDao.getById(id);
    }

    public List<Cv> getAllCvs() throws SQLException {
        return cvDao.getAll();
    }

    public void updateCv(Cv cv) throws SQLException {
        cvDao.update(cv);
    }

    public void deleteCv(int id) throws SQLException {
        cvDao.delete(id);
    }
}
