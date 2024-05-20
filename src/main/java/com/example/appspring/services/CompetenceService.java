package com.example.appspring.services;

import com.example.appspring.datasource.CompetenceDao;
import com.example.appspring.exception.RequestException;
import com.example.appspring.models.Competence;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class CompetenceService {
    private CompetenceDao competenceDao;

    public CompetenceService(Connection connection) {
        this.competenceDao = new CompetenceDao(connection);
    }

    public void createCompetence(Competence competence) throws SQLException {
        if(competence.getCompetanceName()==null){
            throw new RequestException("Id is null", HttpStatus.CONFLICT);
        }else{
        competenceDao.create(competence);
    }}

    public Competence getCompetenceById(int id) throws SQLException {
        if(id == 0){
            throw new RequestException("Id is null", HttpStatus.BAD_REQUEST);
        }else {
            return  competenceDao.getById(id);
        }
    }

    public List<Competence> getAllCompetences() throws SQLException {
        return competenceDao.getAll();
    }

    public void updateCompetence(Competence competence) throws SQLException {
        competenceDao.update(competence);
    }

    public void deleteCompetence(int id) throws SQLException {
        competenceDao.delete(id);
    }
}
