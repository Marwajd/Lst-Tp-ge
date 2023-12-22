package Controller;

import Modules.Departement;
import Modules.Enseignant;
import Modules.Etudiant;
import Modules.Filieres;
import Services.*;

import static Services.Main.affichermenuprincipale;

public class Filierescontroller {
    public static void afficherMenu(){
        System.out.println("--------------------[Menu Filiéres]-----------------------");
        System.out.println("1.pour ajouter une Filéres ");
        System.out.println("2.pour afficher une Filéres ");
        System.out.println("3.pour modifier une Filéres");
        System.out.println("4.pour  supprimer une Filéres");
        System.out.println("5.pour retourner au menu principale");
        int option = Main.getIntInput("choisir une option :");
        switch (option) {
            case 1:
                ajouterFilieres();
                break;
            case 2:
                afficherFilieres();
                break;
            case 3:
                modifierFilieres();
                break;
            case 4:
                supprimerFilieres();
                break;
            case 5:
                affichermenuprincipale();
                break;
            default:
                System.out.println("Option non valide");
        }
    }
    public static void ajouterFilieres(){
        while (true) {
            String intitule = Main.getStringInput("Saisie l'intitule de la filiére :");

            int ide = Main.getIntInput("Sélectionnez une enseignant par ID :");
            Enseignant responsable= Enseignantsservices.getEnsById(ide);
            int idd = Main.getIntInput("Sélectionnez une departement  par ID :");
           Departement departement= Departementsservices.getDeptById(idd);

            if (responsable== null|| departement==null) {
                System.out.println("L'enseingnat ou le departements  n'existe pas. Veuillez réessayer.");
            } else {
                Filieres filiere = Filieresservices.ajouterFiliere(intitule, responsable, departement);
                if (filiere != null) {
                    System.out.println("L'ajout du filiére avec succès");
                    break;
                } else {
                    System.out.println("Échec de l'ajout. Veuillez réessayer.");
                }
            }
        }
        afficherMenu();

    }


    public static void afficherFilieres() {
        for (Filieres filiere : Configuration.filieres) {
            System.out.print("ID : " + filiere.getId() + " | ");
            System.out.print("Intitulé : " + filiere.getIntitule() + " | ");

            Enseignant responsable = filiere.getResponsable();
            if (responsable != null) {
                System.out.print("Responsable : " + responsable.getNom() + " " + responsable.getPrenom() + " | ");
            }

            Departement departement = filiere.getDept();
            if (departement != null) {
                System.out.print("Département : " + departement.getIntitule());
                Enseignant responsableDepartement = departement.getresponsable();
                if (responsableDepartement != null) {
                    System.out.print(" | Responsable Département : " + responsableDepartement.getNom() + " " + responsableDepartement.getPrenom());
                }
            }

            System.out.println(""); // Saut de ligne pour chaque filière
        }
    }


    public static void modifierFilieres() {
        int id = Main.getIntInput("Entrer l'ID de la filière à modifier: ");
        Filieres filiereAModifier = Filieresservices.getFlById(id);

        if (filiereAModifier != null) {
            String intitule = Main.getStringInput("Saisir le nouveau intitule :");
            int idEnseignant = Main.getIntInput("Entrer le nouvel ID de l'enseignant :");
            Enseignant responsable = Enseignantsservices.getEnsById(idEnseignant);
            int idDepartement = Main.getIntInput("Entrer le nouvel ID de département :");
            Departement departement = Departementsservices.getDeptById(idDepartement);

            Filieres filiereModifiee = Filieresservices.modifierFiliere(id, intitule, responsable, departement);
            if (filiereModifiee != null) {
                System.out.println("Filière modifiée avec succès.");
            } else {
                System.out.println("Échec de la modification de la filière. Veuillez réessayer.");
            }
        } else {
            System.out.println("Filière non trouvée pour l'ID spécifié.");
        }
        afficherFilieres();
        afficherMenu();
    }

    public static void  supprimerFilieres() {
        int id = Main.getIntInput("Entrer l'ID de la filière à supprimer :");

        String confirmation = Main.getStringInput("Êtes-vous sûr de vouloir supprimer cette filière ? (O/N)");
        if (confirmation.equalsIgnoreCase("O")) {
            Filieresservices.supprimerFlById(id);
            System.out.println("Filière supprimée avec succès.");
        } else {
            System.out.println("Suppression annulée.");
        }
        afficherFilieres();
        afficherMenu();
    }
}
