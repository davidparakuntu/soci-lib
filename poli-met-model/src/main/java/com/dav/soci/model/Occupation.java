package com.dav.soci.model;

import java.util.List;

public class Occupation {
    private Proffesion currentProffesion;
    private List<Proffesion> proffesionHistory;

    public Proffesion getCurrentProffesion() {
        return currentProffesion;
    }

    public void setCurrentProffesion(Proffesion currentProffesion) {
        this.currentProffesion = currentProffesion;
    }

    public List<Proffesion> getProffesionHistory() {
        return proffesionHistory;
    }

    public void setProffesionHistory(List<Proffesion> proffesionHistory) {
        this.proffesionHistory = proffesionHistory;
    }
}
