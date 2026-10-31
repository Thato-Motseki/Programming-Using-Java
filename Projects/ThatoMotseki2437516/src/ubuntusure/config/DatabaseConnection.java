/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubuntusure.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thato
 */
public class DatabaseConnection {

    private static final String URL
            = "jdbc:mysql://localhost:3306/ThatoMotseki2437516?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Africa/Maseru";

    private static final String USER = "root";

    private static final String PASSWORD = "Thato0505@";

    private DatabaseConnection() {
        // Prevent unnecessary object creation.
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
