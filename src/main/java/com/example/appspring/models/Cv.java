package com.example.appspring.models;

import java.util.List;

public class Cv {
    private int id;
    private String profile;
    private informationperso informationPerso; // Ajout d'un attribut pour les informations personnelles
    private List<Competence> competences; // Ajout d'un attribut pour les compétences
    private List<Entreprise> entreprises; // Ajout d'un attribut pour les entreprises

    public Cv() {}

    public Cv(String profile, informationperso informationPerso, List<Competence> competences, List<Entreprise> entreprises) {
        this.profile = profile;
        this.informationPerso = informationPerso;
        this.competences = competences;
        this.entreprises = entreprises;
    }

    public informationperso getInformationPerso() {
        return informationPerso;
    }

    public void setInformationPerso(informationperso informationPerso) {
        this.informationPerso = informationPerso;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public List<Entreprise> getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(List<Entreprise> entreprises) {
        this.entreprises = entreprises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Cv{" +
                "id=" + id +
                ", profile='" + profile + '\'' +
                ", informationPerso=" + informationPerso +
                ", competences=" + competences +
                ", entreprises=" + entreprises +
                '}';
    }
}
