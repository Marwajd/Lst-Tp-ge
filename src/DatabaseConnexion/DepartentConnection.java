package DatabaseConnexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DepartentConnection {
    private static Connection connection = null;

    public DepartentConnection() {
    }
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Établissement de la connexion à la base de données
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                        "projet_gestioneducative", "root", "Marwa2003");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

