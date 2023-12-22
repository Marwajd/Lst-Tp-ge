package Modules;

public class Notes {
    private float note;
    private Etudiant etudiant;
    private Filieres filiere;

    public Notes() {
    }

    public Notes(float note, Etudiant etudiant, Filieres filiere) {
        this.note = note;
        this.etudiant = etudiant;
        this.filiere = filiere;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Filieres getFiliere() {
        return filiere;
    }

    public void setFiliere(Filieres filiere) {
        this.filiere = filiere;
    }
}
