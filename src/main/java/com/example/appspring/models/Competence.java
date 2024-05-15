package com.example.appspring.models;

public class Competencse {
    private int competanceId;
    private String competanceName;

    public Competence() {}

    public Competence(String competanceName) {
        this.competanceName = competanceName;
    }

    public int getCompetanceId() {
        return competanceId;
    }

    public void setCompetanceId(int competanceId) {
        this.competanceId = competanceId;
    }

    public String getCompetanceName() {
        return competanceName;
    }

    public void setCompetanceName(String competanceName) {
        this.competanceName = competanceName;
    }

    @Override
    public String toString() {
        return "Competence{" +
                "competanceId=" + competanceId +
                ", competanceName='" + competanceName + '\'' +
                '}';
    }
}
