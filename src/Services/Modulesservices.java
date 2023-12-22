package Services;

import Modules.Enseignant;
import Modules.Filieres;
import Modules.Modules;

import java.util.ArrayList;

public class Modulesservices{

    public static Modules ajouterModule(String intitule, Enseignant prof, Filieres filiere) {
        Modules module = new Modules();
        module.setIntitule(intitule);

        if (prof != null) {
            module.setProfesseur(prof);
        }

        if (filiere != null) {
            module.setFiliere(filiere);
        }


        module.setId(Configuration.getModId());

        // Ajout à la liste
        Configuration.modules.add(module);
        return module;
    }

    public static Modules modifierModule(int id, String intitule, Enseignant prof, Filieres filiere) {
        for (Modules module : Configuration.modules) {
            if (module.getId() == id) {
                module.setIntitule(intitule);
                module.setProfesseur(prof);
                module.setFiliere(filiere);
                return module;
            }
        }
        return null;
    }
    public static ArrayList<Modules> supprimerModuleById(int id) {
        Modules moduleASupprimer = getModuleById(id);
        if (moduleASupprimer != null) {
            Configuration.modules.remove(moduleASupprimer);
        }
        return Configuration.modules;
    }

    public static Modules getModuleById(int id){
            for (Modules module: Configuration.modules) {
                if (module.getId() == id) {
                    return module;
                }
            }
            return null; // Retourne null si aucun département correspondant à l'ID
        }

    public static ArrayList<Modules> getAllModule(){
        return  Configuration.modules;
    }
}


