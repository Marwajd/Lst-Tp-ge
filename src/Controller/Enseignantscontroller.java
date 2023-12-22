package Controller;

import Modules.Departement;
import Modules.Enseignant;
import Services.Configuration;
import Services.Departementsservices;
import Services.Enseignantsservices;
import Services.Main;

import static Services.Main.affichermenuprincipale;

public class Enseignantscontroller {
    public static void afficherMenu() {
        System.out.println("--------------------[Menu Enseignant]-----------------------");
        System.out.println("1.pour ajouter un enseignant");
        System.out.println("2.pour afficher  un  enseignant");
        System.out.println("3.pour modifier un enseignant");
        System.out.println("4.pour  supprimer un enseignant");
        System.out.println("5.pour retourner au menu principale");
        int option = Main.getIntInput("choisir une option :");
        switch (option) {
            case 1:
                ajouterEnseignant();
                break;
            case 2:
                afficherEnseignants();
                break;
            case 3:
                modifierEnseignant();
                break;
            case 4:
                supprimerEnseignant();
                break;
            case 5:
               Main. affichermenuprincipale();
                break;
            default:
                System.out.println("Option non valide");
        }
    }
    public static void afficherEnseignants() {
        for (Enseignant enseignant : Configuration.enseignants) {
            System.out.print("ID : " + enseignant.getId() + " | ");
            System.out.print("Prénom : " + enseignant.getPrenom() + " | ");
            System.out.print("Nom : " + enseignant.getNom() + " | ");
            System.out.print("Email : " + enseignant.getEmail() + " | ");
            System.out.print("Grade : " + enseignant.getGrade() + " | ");
            Departement departement = enseignant.getDepartement();
            if (departement != null) {
                System.out.print("Département : " + departement.getIntitule());
                Enseignant responsable = departement.getresponsable();
                if (responsable != null) {
                    System.out.print(" dirigé par : " + responsable.getNom() + " " + responsable.getPrenom());
                }
            } else {
                System.out.print("Aucun département associé");
            }
            System.out.println(""); // Saut de ligne pour chaque enseignant
        }}
        public static void ajouterEnseignant(){
            String nom = Main.getStringInput("Entrez le nom :");
            String prenom = Main.getStringInput("Entrez le  prenom :");
            String grade = Main.getStringInput("Entrez le grade :");
            String Email = Main.getStringInput("Entrez l'email :");
            Departementscontroller.afficherDepartement();
            int id = Main.getIntInput("Sélecionnez un departement  par id :");
            Departement departement = Departementsservices.getDeptById(id);
            if (departement == null) {
                System.out.println(" departement n'existe pas");
                afficherMenu();
                return;
            }
            if (Enseignantsservices.ajouterEns(nom, prenom, grade, Email, Departementsservices.getDeptById(id)) != null) {
                System.out.println("L'ajout enseignant avec succés");
                afficherEnseignants();
            } else {
                System.out.println("echec d'ajout");
            }
            afficherMenu();
        }
    public static void modifierEnseignant() {
        afficherEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseignant par ID :");
        Enseignant enseignantAModifier = Enseignantsservices.getEnsById(id);

        if (enseignantAModifier == null) {
            System.out.println("Enseignant non trouvé.");
            afficherMenu();
            return;
        }
        String nom = Main.getStringInput("Entrez le nouveau nom :");
        String prenom = Main.getStringInput("Entrez le nouveau prénom :");
        String grade = Main.getStringInput("Entrez le nouveau grade :");
        String email = Main.getStringInput("Entrez le nouvel email :");

        Departementscontroller.afficherDepartement();
        int idDepartement = Main.getIntInput("Sélectionnez un département par ID :");
        Departement departement = Departementsservices.getDeptById(idDepartement);

        if (departement == null) {
            System.out.println("Département non trouvé.");
            afficherMenu();
            return;
        }

        Enseignantsservices.modifierEns(id, nom, prenom, email, grade, departement);
        System.out.println("Enseignant modifié avec succès.");
        afficherEnseignants();
        afficherMenu();
    }

    public static void supprimerEnseignant () {
            afficherEnseignants();
            int id = Main.getIntInput("Sélecionnez un enseignant par id :");
            Enseignantsservices.supprimerEnseignantParId(id);
            afficherEnseignants();
            afficherMenu();
        }

    }



