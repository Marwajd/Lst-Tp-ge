package Services;


import Modules.Departement;
import Modules.Enseignant;
import Modules.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
    public class Departementsservices {

        private static final String URL = "jdbc:mysql://localhost:3306/gestion_dept";
        private static final String USER = "root";
        private static final String PASSWORD = "Marwa2003";

        public static void createTable() {
            try (Connection cx = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement st = cx.createStatement()) {
                String query = "CREATE TABLE IF NOT EXISTS departements (" +
                        "id int primary key auto_increment, " +
                        "intitule varchar(255), " +
                        "responsable int" +
                        ")";
                st.execute(query);
                System.out.println("Table 'departements' créée avec succès !");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la création de la table 'departements'");
                e.printStackTrace();
            }
        }

        public static List<Departement> getAllDepartements() {
            List<Departement> departements = new ArrayList<>();
            try (Connection cx = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement st = cx.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM departements")) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String intitule = rs.getString("intitule");
                    int responsableId = rs.getInt("responsable");

                    // Récupérer l'enseignant correspondant à l'ID depuis la base de données
                    Enseignant responsable = Enseignantsservices.getEnsById(responsableId);

                    Departement departement = new Departement(intitule, responsable);
                    departement.setId(id);
                    departements.add(departement);
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la récupération des départements.");
                e.printStackTrace();
            }
            return departements;
        }

        public static void ajouterDept(String intitule, int responsable) {
            try (Connection cx = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement ps = cx.prepareStatement("INSERT INTO departements (intitule, responsable) VALUES (?, ?)")) {
                ps.setString(1, intitule);
                ps.setInt(2, responsable);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Département inséré avec succès !");
                } else {
                    System.out.println("Échec de l'insertion du département.");
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de l'insertion du département.");
                e.printStackTrace();
            }
        }

        public static void deleteDepartement(int idDep) {
            try (Connection cx = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement ps = cx.prepareStatement("DELETE FROM departements WHERE id = ?")) {
                ps.setInt(1, idDep);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Département supprimé avec succès !");
                } else {
                    System.out.println("Échec de la suppression du département.");
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la suppression du département.");
                e.printStackTrace();
            }
        }
        public static void modifyDepartement(int id, String newIntitule, int newResponsable) {
            try (Connection cx = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement ps = cx.prepareStatement("UPDATE departements SET intitule = ?, responsable = ? WHERE id = ?")) {
                ps.setString(1, newIntitule);
                ps.setInt(2, newResponsable);
                ps.setInt(3, id);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Département modifié avec succès !");
                } else {
                    System.out.println("Échec de la modification du département.");
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la modification du département.");
                e.printStackTrace();
            }
        }

        public  static Departement getDeptById(int id) {
            for (Departement departement : Configuration.departements) {
                if (departement.getId() == id) {
                    return departement;
                }
            }
            return null; // Retourne null si aucun département correspondant à l'ID n'est trouvé
        }

    }


    //base de donnee
    /*    public static Departement ajouterDept(String intitule, Enseignant responsable) {
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
*/


