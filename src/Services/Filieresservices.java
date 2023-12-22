package Services;

import Modules.Departement;
import Modules.Enseignant;
import Modules.Etudiant;
import Modules.Filieres;

import java.util.ArrayList;

public class Filieresservices {
    public static Filieres ajouterFiliere(String intitule, Enseignant responsable, Departement dept) {
        Filieres filiere = new Filieres();
        filiere.setIntitule(intitule);
        filiere.setResponsable(responsable);
        filiere.setDept(dept);
        filiere.setId(Configuration.getFilId());
        Configuration.filieres.add(filiere);
        return filiere;
    }

    public static Filieres modifierFiliere(int id , String intitule, Enseignant responsable, Departement dept){
        for ( Filieres filiere: Configuration.filieres) {
            if (filiere.getId() == id) {
                filiere.setIntitule(intitule);
                filiere.setResponsable(responsable);
                filiere.setDept(dept);

                return filiere;
            }
        }
        return null;
    }

    public static ArrayList<Filieres> supprimerFlById(int id){
       Filieres filieresASupprimer = null;
        for (Filieres filiere : Configuration.filieres) {
            if (filiere.getId() == id) {
                filieresASupprimer = filiere;
                break;
            }
        }
        if (filieresASupprimer != null) {
            Configuration.filieres.remove(filieresASupprimer);
        }
        return Configuration.filieres; // Retourne la liste mise à jour des étudiants
    }

    public static Filieres getFlById(int id){
        for ( Filieres filiere: Configuration.filieres) {
            if (filiere.getId() == id) {
                return filiere;
            }
        }
        return null;
    }


    public static ArrayList<Filieres> getAllFl(){
    return new ArrayList<>(Configuration.filieres); // Retourne une copie de la liste pour éviter les modifications directes
}}


