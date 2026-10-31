

package thatomotseki2437516; 
import java.sql.Connection; 
import java.sql.SQLException;

import ubuntusure.config.DatabaseConnection;
import ubuntusure.ui.Splash;

/**
 *
 * @author thato
 */
public class ThatoMotseki2437516 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        System.out.println("UbuntuSure Insurance System");
//        System.out.println("Testing database connection...");
//
//        try (Connection connection =
//                     DatabaseConnection.getConnection()) {
//
//            if (connection.isValid(5)) {
//                System.out.println(
//                        "SUCCESS: Connected to the MySQL database."
//                );
//                System.out.println(
//                        "Database: "
//                        + connection.getCatalog()
//                );
//            }
//
//        } catch (SQLException e) {
//            System.err.println(
//                    "ERROR: Could not connect to the database."
//            );
//            System.err.println("Reason: " + e.getMessage());
//        }

        Splash splashScreen = new Splash();
        splashScreen.setVisible(true);
        splashScreen.pack();
        splashScreen.setLocationRelativeTo(null);
    }

}


        
   