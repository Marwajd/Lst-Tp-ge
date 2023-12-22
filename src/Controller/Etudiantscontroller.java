package Controller;

import Modules.Departement;
import Modules.Enseignant;
import Modules.Etudiant;
import Modules.Filieres;
import Services.*;

import static Services.Main.affichermenuprincipale;

public class Etudiantscontroller {

    public static void afficherMenu(){
        System.out.println("--------------------[Menu Etudiants]-----------------------");
        System.out.println("1.pour ajouter un etudiant");
        System.out.println("2.pour afficher  un etudiant");
        System.out.println("3.pour modifier un etudiantt");
        System.out.println("4.pour  supprimer un etudiant");
        System.out.println("5.pour retourner au menu principale");
        int option = Main.getIntInput("choisir une option :");
        switch (option) {
            case 1:
                ajouterEtudiant();
                break;
            case 2:
                afficherEtudiant();
                break;
            case 3:
                modifierEtudiant();
                break;
            case 4:
                supprimerEtudiant();
                break;
            case 5:
                affichermenuprincipale();
                break;
            default:
                System.out.println("Option non valide");
        }
    }
    public static void ajouterEtudiant(){
            while (true) {
                String nom = Main.getStringInput("Saisie le nom d'étudiants :");
                String prenom = Main.getStringInput("Entrez le prénom d'étudiants :");
                String email = Main.getStringInput("Entrez l'email d'étudiants :");
                int apogee = Main.getIntInput("Entrez l'apogee d'étudiants :");
                int id = Main.getIntInput("Sélectionnez une filière par ID :");
                Filieres filiere = Filieresservices.getFlById(id);

                if (filiere == null) {
                    System.out.println("La filière n'existe pas. Veuillez réessayer.");
                } else {
                    Etudiant etudiant = Etudiantsservices.ajouterEtd(nom, prenom, email, apogee, filiere);
                    if (etudiant != null) {
                        System.out.println("L'ajout d'étudiant avec succès");
                        break;
                    } else {
                        System.out.println("Échec de l'ajout. Veuillez réessayer.");
                    }
                }
            }
            afficherMenu();
        }


public static void afficherEtudiant(){
        for (Etudiant etudiant : Configuration.etudiants) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | Nom : " + etudiant.getNom() + " " + etudiant.getPrenom());
            System.out.print(" | Email : " + etudiant.getEmail());
            System.out.print(" | Apogee : " + etudiant.getApogee());

            Filieres filiere = etudiant.getFiliere();
            if (filiere != null) {
                System.out.print(" | Filières : " + filiere.getIntitule());
                Enseignant responsable = filiere.getResponsable();
                if (responsable != null) {
                    System.out.print(" | Responsable : " + responsable.getNom() + " " + responsable.getPrenom());
                }
                Departement departement = filiere.getDept();
                if (departement != null) {
                    System.out.print(" | Département : " + departement.getIntitule());
                }
            } else {
                System.out.print(" | Filières : ");
            }
            System.out.println("");
        }
    }

    public static void modifierEtudiant(){
        afficherEtudiant();
        int id = Main.getIntInput("Entrer l'ID de l'etudiant à modifier: ");
        // Demander les nouvelles informations
        String nom = Main.getStringInput("Saisir le nouveau nom :");
        String prenom = Main.getStringInput("Saisir le nouveau prénom :");
        String email = Main.getStringInput("Saisir le nouvel email :");
        int apogee = Main.getIntInput("Saisir le nouveau apogee :");

        int idFlt = Main.getIntInput("Entrer le nouvel ID de la filéres :");
        Filieres filieres = Filieresservices.getFlById(idFlt);

        Etudiantsservices.modifierEtd(id, nom, prenom, email, apogee, filieres);

        // Afficher les enseignants mis à jour
        afficherEtudiant();
        afficherMenu();
    }

    public static void supprimerEtudiant(){
        afficherEtudiant();
        int id = Main.getIntInput("Entrer l'ID de l'étudiant à supprimer :");
        String confirmation = Main.getStringInput("Êtes-vous sûr " +
                "de vouloir supprimer cet étudiant ? (O/N)");
        // Demande confirmation
        System.out.println("Confirmation : " + confirmation); // Affiche la valeur saisie par l'utilisateur
        if (confirmation.equalsIgnoreCase("O")) {
            //  suppression
            Etudiantsservices.supprimerEtdById(id);
            System.out.println("Étudiant supprimé avec succès.");
        } else {
            System.out.println("Suppression annulée.");
        } afficherEtudiant();
        afficherMenu();


        }

}

