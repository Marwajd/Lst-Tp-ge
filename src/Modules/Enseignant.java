package Modules;

import java.util.ArrayList;

public class Enseignant {
    private static int Id;
    private String nom;
    private String prenom;
    private String email;
    private String grade;
    private Departement departement;
    ArrayList<Modules> modules=new ArrayList<Modules>();

    public Enseignant() {
    }

    public Enseignant(String nom, String prenom, String email, String grade, Departement departement) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.departement = departement;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public ArrayList<Modules> getModules() {
        return modules;
    }

    public int getId() {
        return Id;
    }

    public static void setId(int id) {
        Id = id;
    }
    /*D'abord, il vérifie si l'objet "Enseignant" qu'on lui donne à comparer est vide (ou s'il n'existe pas).
     Si c'est le cas, il dit que les objets ne sont pas les mêmes.
    Ensuite, il regarde si l'identifiant de l'objet "Enseignant" que vous avez maintenant est le même que celui de l'objet "Enseignant"
     avec lequel vous comparez. Si ces identifiants sont différents, il dit que les objets ne sont pas les mêmes.
    Si ces deux conditions ne sont pas vraies, alors le code dit que les objets sont les mêmes. Mais notez que cette méthode ne compare
    que les identifiants pour dire si les objets sont les mêmes, pas d'autres informations à leur sujet.*/

    public boolean equals(Enseignant obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getId() != this.Id) {
            return false;
        }

        return true;
    }
}


