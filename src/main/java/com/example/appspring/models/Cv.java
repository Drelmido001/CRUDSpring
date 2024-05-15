package com.example.appspring.models;

public class Cv {
    private int id;
    private String fullname;
    private String email;
    private String profile;
    public Cv(){ }
    public Cv(int id, String fullname, String email, String profile) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.profile = profile;
    }
    public Cv(String fullname, String email, String profile) {
        this.fullname = fullname;
        this.email = email;
        this.profile = profile;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
