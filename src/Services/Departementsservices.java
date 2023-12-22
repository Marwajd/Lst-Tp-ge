package Services;


import Modules.Departement;
import Modules.Enseignant;
import Modules.Etudiant;

import java.util.ArrayList;
public class Departementsservices {

        public static Departement ajouterDept(String intitule, Enseignant responsable) {
            Departement departement = new Departement();
            departement.setIntitule(intitule);
            departement.setresponsable(responsable);

           departement.setId(Configuration.getDeptId());
            Configuration.departements.add(departement);
            return departement;
        }

    public static Departement modifierDept(int id, String intitule, Enseignant responsable) {
        for ( Departement departement: Configuration.departements) {
            if (departement.getId() == id) {
                departement.setIntitule(intitule);
               departement.setresponsable(responsable);

                return departement;
            }
        }
        return null; // Aucun étudiant trouvé pour cet ID
    }


    public static ArrayList<Departement> supprimerDepartementParId(int id) {
        Configuration.departements.remove(getDeptById(id));
        return Configuration.departements;
    }


            public  static Departement getDeptById(int id) {
            for (Departement departement : Configuration.departements) {
                if (departement.getId() == id) {
                    return departement;
                }
            }
            return null; // Retourne null si aucun département correspondant à l'ID
        }

        public static ArrayList<Departement> getAllDepartements() {
            return Configuration.departements;
        }

}



