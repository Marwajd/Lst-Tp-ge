package Controller;

import Modules.Departement;
import Modules.Enseignant;
import Modules.Filieres;
import Modules.Modules;
import Services.*;

import static Services.Main.affichermenuprincipale;

public class Modulescontroller{
    public static void afficherMenu(){
    System.out.println("--------------------[Menu Modules]-----------------------");
    System.out.println("1.pour ajouter un Modules ");
    System.out.println("2.pour afficher un Modules ");
    System.out.println("3.pour modifier un Modules");
    System.out.println("4.pour  supprimer un Modules");
    System.out.println("5.pour retourner au menu principale");
    int option = Main.getIntInput("choisir une option :");
    switch (option) {
        case 1:
           ajouterModules();
            break;
        case 2:
                afficherModules();
            break;
        case 3:
            modifierModules();
            break;
        case 4:
          supprimerModules();
            break;
        case 5:
            affichermenuprincipale();
            break;
        default:
            System.out.println("Option non valide");
    }
}

    public static void afficherModules() {
        for (Modules module : Configuration.modules) {
            System.out.print("Id : " + module.getId());
            System.out.print(" | Intitulé : " + module.getIntitule());
            if (!Main.Isnull(module.getProfesseur())) {
                System.out.print(" | Responsable : " + module.getProfesseur().getNom() +
                        " " + module.getProfesseur().getPrenom());
                if (!Main.Isnull(module.getFiliere())) {
                    System.out.print(" | Filieres : " + module.getFiliere().getIntitule() );

            }}
            System.out.println("");
        }}


    public static void ajouterModules() {
        String intitule = Main.getStringInput("Saisir l'intitulé du Modules :");
        Enseignantscontroller.afficherEnseignants();
        int idEns = Main.getIntInput("Sélectionner un enseignant par ID :");
        Enseignant prof = Enseignantsservices.getEnsById(idEns);
        Filierescontroller.afficherFilieres();
        int idFlt = Main.getIntInput("Sélectionner une filière par ID :");
        Filieres filiere =Filieresservices.getFlById(idFlt);

        if (prof == null) {
            System.out.println("L'enseignant n'existe pas");
            afficherMenu();
            return;
        }

        if (filiere == null) {
            System.out.println("La filière n'existe pas");
            afficherMenu();
            return;
        }

        if (Modulesservices.ajouterModule(intitule, prof, filiere) != null) {
            System.out.println("Ajout avec succès");
            afficherModules();
        } else {
            System.out.println("Échec d'ajout");
        }
        afficherMenu();
    }


    public static void modifierModules() {
        afficherModules();
        int id = Main.getIntInput("Entrer un ID du module à modifier :");
        String intitule = Main.getStringInput("Entrer un nouvel intitulé :");

        Enseignantscontroller.afficherEnseignants();
        int idEns = Main.getIntInput("Entrer l'ID du nouvel enseignant :");
        Enseignant prof = Enseignantsservices.getEnsById(idEns);

        Filierescontroller.afficherFilieres();
        int idFlt = Main.getIntInput("Entrer l'ID de la nouvelle filière :");
        Filieres filiere = Filieresservices.getFlById(idFlt);

        if (Modulesservices.modifierModule(id, intitule, prof, filiere) != null) {
            System.out.println("Modification avec succès");
            afficherModules();
        } else {
            System.out.println("Échec de modification");
        }
        afficherMenu();
    }


    public static void supprimerModules() {
        afficherModules();
        int id = Main.getIntInput("Entrer un ID du module à supprimer :");
        Modulesservices.supprimerModuleById(id);
        afficherModules();
        afficherMenu();
    }
}

