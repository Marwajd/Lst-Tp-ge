package Modules;

public class Modules {
    private int id;
    private String intitule;
    private Enseignant professeur;
    private Filieres filiere;

    public Modules() {
    }

    public Modules(int id, String intitule, Enseignant professuer, Filieres filiere) {
        this.id = id;
        this.intitule = intitule;
        this.professeur = professuer;
        this.filiere = filiere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Enseignant professuer) {
        this.professeur = professuer;
    }

    public Filieres getFiliere() {
        return filiere;
    }

    public void setFiliere(Filieres filiere) {
        this.filiere = filiere;
    }
}
