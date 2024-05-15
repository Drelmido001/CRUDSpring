package com.example.appspring.models;

public class informationperso {
    private int id_info;
    private String fullName;
    private String email;

    public informationperso() {}

    public informationperso(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public int getId_info() {
        return id_info;
    }

    public void setId_info(int id_info) {
        this.id_info = id_info;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "InformationPerso{" +
                "id_info=" + id_info +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
