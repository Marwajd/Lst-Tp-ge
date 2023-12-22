package Modules;

import java.util.ArrayList;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int apogee;
    private Filieres filiere;
    ArrayList<Notes> notes = new ArrayList<Notes>();

    public Etudiant() {
    }

    public Etudiant(int id, String nom, String prenom, String email, int apogee, Filieres filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.apogee = apogee;
        this.filiere = filiere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getApogee() {
        return apogee;
    }

    public void setApogee(int apogee) {
        this.apogee = apogee;
    }

    public Filieres getFiliere() {
        return filiere;
    }

    public void setFiliere(Filieres filiere) {
        this.filiere = filiere;
    }

    public ArrayList<Notes> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Notes> notes) {
        this.notes = notes;
    }
}
