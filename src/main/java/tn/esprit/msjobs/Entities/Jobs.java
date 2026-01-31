package tn.esprit.msjobs.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jobs {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String service;
    private boolean etat;

    public Jobs() {
    }

    public Jobs(boolean etat, String service) {
        this.etat = etat;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }




}
