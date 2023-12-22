package DatabaseConnexion;
import Modules.Departement;
import java.sql.*;
import static Services.Enseignantsservices.getEnsById;

import Modules.Departement;
import Modules.Enseignant;
import Services.Enseignantsservices;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class DepartementDatabase{
    public static void main(String[] args) {

                String url = "jdbc:mysql://localhost:3306/projet_gestioneducative";
                String user = "root";
                String pwd = "Marwa2003";

                try {
                    Connection cx = DriverManager.getConnection(url, user, pwd);
                    System.out.println("Connexion réussie.");

                    createTable(cx);

                    insertDepartement(cx, "MIP", 1);
                    insertDepartement(cx, "GEGM", 2);

                    int idToDelete = 9;
                    deleteDepartement(idToDelete, cx);

                    List<Departement> departements = getAllDepartements(cx);
                    for (Departement departement : departements) {
                        System.out.println(departement.toString());
                    }

                } catch (SQLException e) {
                    System.out.println("Échec de la connexion.");
                    e.printStackTrace();
                }
            }

            public static void createTable(Connection cx) throws SQLException {
                String query = "CREATE TABLE IF NOT EXISTS departements (" +
                        "id int primary key auto_increment, " +
                        "intitule varchar(255), " +
                        "responsable int" +
                        ")";
                try (Statement st = cx.createStatement()) {
                    st.execute(query);
                    System.out.println("Table 'departements' créée avec succès !");
                } catch (SQLException e) {
                    System.out.println("Erreur lors de la création de la table 'departements'");
                    e.printStackTrace();
                }
            }

            public static List<Departement> getAllDepartements(Connection cx) {
                List<Departement> departements = new ArrayList<>();
                String query = "SELECT * FROM departements";
                try (Statement st = cx.createStatement();
                     ResultSet rs = st.executeQuery(query)) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String intitule = rs.getString("intitule");
                        int responsable = rs.getInt("responsable");
                   //     Departement departement = new Departement(responsable, intitule);
                     //   departement.setId(id);
                      //  departements.add(departement);
                    }
                } catch (SQLException e) {
                    System.out.println("Erreur lors de la récupération des départements.");
                    e.printStackTrace();
                }
                return departements;
            }

            public static void insertDepartement(Connection cx, String intitule, int responsable) {
                String query = "INSERT INTO departements (intitule, responsable) VALUES (?, ?)";
                try (PreparedStatement ps = cx.prepareStatement(query)) {
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

    public static void deleteDepartement(int idDep, Connection cx) {
        String sql = "DELETE FROM departements WHERE id = ?";
        try (PreparedStatement ps = cx.prepareStatement(sql)) {
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
}


