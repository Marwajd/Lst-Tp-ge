package Services;

import Modules.Enseignant;
import Modules.Etudiant;
import Modules.Filieres;

import java.util.ArrayList;

public class Etudiantsservices {

    public static Etudiant ajouterEtd(String nom, String prenom, String email, int apogee, Filieres filiere) {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setEmail(email);
        etudiant.setApogee(apogee);
        etudiant.setFiliere(filiere);
        etudiant.setId(Configuration.getEtdId());
        Configuration.etudiants.add(etudiant);
        return etudiant;
    }

    public static Etudiant modifierEtd(int id, String nom, String prenom, String email, int apogee, Filieres filiere) {
        for (Etudiant etudiant : Configuration.etudiants) {
            if (etudiant.getId() == id) {
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setEmail(email);
                etudiant.setApogee(apogee);
                etudiant.setFiliere(filiere);
                return etudiant;
            }
        }
        return null; // Aucun étudiant trouvé pour cet ID
    }

    public static ArrayList<Etudiant> supprimerEtdById(int id) {
        Etudiant etudiantASupprimer = null;
        for (Etudiant etudiant : Configuration.etudiants) {
            if (etudiant.getId() == id) {
                etudiantASupprimer = etudiant;
                break;
            }
        }
        if (etudiantASupprimer != null) {
            Configuration.etudiants.remove(etudiantASupprimer);
        }
        return Configuration.etudiants; // Retourne la liste mise à jour des étudiants
    }
    public static Etudiant getEtdById(int id) {
        for (Etudiant etudiant : Configuration.etudiants) {
            if (etudiant.getId() == id) {
                return etudiant;
            }
        }
        return null;
    }

    public static ArrayList<Etudiant> getAllEtd() {
        return Configuration.etudiants;
    }
}


