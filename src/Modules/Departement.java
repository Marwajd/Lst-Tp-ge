package Modules;

import java.util.ArrayList;

public class Departement {
    private int id;
    private String intitule;
    private Enseignant responsable;
    private int respo;
    ArrayList<Filieres> filieres = new ArrayList<Filieres>();

    public Departement() {
    }

    public Departement(String intitule, Enseignant responsable) {
        this.intitule=intitule;
        this.responsable=responsable;
    }




    //les constructeurs

    //les methodes getters and setters

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public  Enseignant getresponsable() {
        return responsable;
    }

    public void setresponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public ArrayList<Filieres> getFilieres() {
        return filieres;
    }

    public void setFilieres(ArrayList<Filieres> filieres) {
        this.filieres = filieres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
