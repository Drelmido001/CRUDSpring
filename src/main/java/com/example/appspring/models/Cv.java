package com.example.appspring.models;

import java.util.List;

public class Cv {
    private int id;
    private String profile;
    private int id_info;

    public Cv() {}

    public Cv(String profile, int id_info) {
        this.profile = profile;
        this.id_info = id_info;
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

    public int getId_info() {
        return id_info;
    }

    public void setId_info(int id_info) {
        this.id_info = id_info;
    }

    @Override
    public String toString() {
        return "CV{" +
                "id=" + id +
                ", profile='" + profile + '\'' +
                ", id_info=" + id_info +
                '}';
    }
}
