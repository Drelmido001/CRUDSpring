package com.example.appspring.models;

public class Competence {
    private int competanceId;
    private String competanceName;

    // Constructeurs

    // Getters et Setters
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

    // Autres méthodes

    @Override
    public String toString() {
        return "Competence{" +
                "competanceId=" + competanceId +
                ", competanceName='" + competanceName + '\'' +
                '}';
    }
}
