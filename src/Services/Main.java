package Services;
import Controller.*;
import Modules.*;
import Services.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    //fonction indique qu'une instance est null
    public static boolean Isnull(Object ob) {
        return ob == null;
    }

//fonction qui affiche un message par défaut si l'uti n'entre rien on envoie l'entier à l'edroit ou cet fonction est appellée

    public static int getIntInput(String... msg) {
        Scanner scanner = new Scanner(System.in);
        String message = ("Entrer un entier :");
       // message=scanner.nextLine();
        if (msg.length > 0)
            message = msg[0];
            System.out.println(message);
            int num = scanner.nextInt();

            return num;
        }
    //fonction qui affiche un message par défaut si l'uti n'entre rien on envoie le texte à l'edroit ou cet fonction est appellée
public static String getStringInput(String... msg){
    Scanner scanner = new Scanner(System.in);
         String message=("Entrer un texte :");
        // message=scanner.nextLine();
         if(msg.length>0)
             message=msg[0];

    System.out.println(message);
         String st=scanner.nextLine();

         return st;
}

    public static void affichermenuprincipale() {
        System.out.println("---------------[Welcome]--------------------");
        System.out.println("1.pour gérer les Département");
        System.out.println("2.pour gérer les Enseignants");
        System.out.println("3.pour gérer les Etudiants");
        System.out.println("4.pour gérer les Filiéres");
        System.out.println("5.pour gérer les Modules");
        System.out.println("0.pour sortir");
        int option=getIntInput("sélectionner une option :");
        switch (option) {
            case 1:
                Departementscontroller.afficherMenu();
                break;
            case 2:
                Enseignantscontroller.afficherMenu();
                break;
            case 3:
                Etudiantscontroller.afficherMenu();
                break;
            case 4:
              Filierescontroller.afficherMenu();
                break;
            case 5:
               Modulescontroller.afficherMenu();
                break;
            default:
                System.out.println("Option choisis est invalides :");

        }
    }
        //assigne cet identifiant (Id) récupéré par getEnsId() à l'enseignant.
        // Cela signifie que la valeur retournée par Configuration.getEnsId()
        // est définie comme l'identifiant de l'enseignant en question.
//cela signifie que vous ajoutez l'objet enseignant à la collection enseignants
        // de la classe Configuration. Cette opération permet de conserver une liste d'enseignants
        // au sein de la classe Configuration, ce qui pourrait être utile pour stocker et gérer différentes
        //informations relatives aux enseignants dans votre programme.
        // ...

    public static void main(String[] args)  {
     // Création d'un enseignant
        Enseignant enseignant = new Enseignant();
        enseignant.setNom("DACHRY");
        enseignant.setPrenom("WAFAA");
        enseignant.setEmail("DACHRYWAFAA@gmail.com");
        enseignant.setGrade("ABC");
       // enseignant.setDepartement(enseignant.getDepartement());
        enseignant.setId(Configuration.getEnsId());
        Configuration.enseignants.add(enseignant);
            //creation de departement
        Departement D1 = new Departement();
        D1.setIntitule("GEGM");
        D1.setresponsable(enseignant);

        // Création d'un étudiant
        Etudiant E1 = new Etudiant();
        E1.setNom("Marwa");
        E1.setPrenom("Jaida");
        E1.setEmail("Marwajaida@gmail.com");
        E1.setApogee(1233);
        E1.setId(Configuration.getEtdId());
        Configuration.etudiants.add(E1);


        // Création d'une filière
        Filieres F1 = new Filieres();
        F1.setIntitule("SITD");
        F1.setResponsable(enseignant);
        F1.setDept(D1);
        F1.setId(Configuration.getFilId());
        Configuration.filieres.add(F1);

        //création d'un module

        Modules module = new Modules();
        module.setIntitule("POO");
        module.setFiliere(F1);
        module.setProfesseur(enseignant);

        //Affichage du menu principal

      affichermenuprincipale();
    }
}

