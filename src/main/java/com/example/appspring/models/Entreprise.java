package com.example.appspring.models;

public class Entreprise {
    private int idEntreprise;
    private String nom;
    private String emailEntreprise;

    public Entreprise() {}

    public Entreprise(String nom, String emailEntreprise) {
        this.nom = nom;
        this.emailEntreprise = emailEntreprise;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmailEntreprise() {
        return emailEntreprise;
    }

    public void setEmailEntreprise(String emailEntreprise) {
        this.emailEntreprise = emailEntreprise;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "idEntreprise=" + idEntreprise +
                ", nom='" + nom + '\'' +
                ", emailEntreprise='" + emailEntreprise + '\'' +
                '}';
    }
}
