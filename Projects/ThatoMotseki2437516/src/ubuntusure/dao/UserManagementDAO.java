/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubuntusure.dao;

import ubuntusure.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UserManagementDAO {

// Retrieve all users
    public List<Object[]> getAllUsers() throws SQLException {

        List<Object[]> users = new ArrayList<>();

        String sql = "SELECT u.user_ID, u.firstname, u.surname, "
                + "u.username, r.roleName, u.is_active "
                + "FROM `USER` u "
                + "INNER JOIN ROLE r ON u.role_ID = r.role_ID "
                + "ORDER BY u.user_ID";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Object[] user = {
                    rs.getInt("user_ID"),
                    rs.getString("firstname"),
                    rs.getString("surname"),
                    rs.getString("username"),
                    rs.getString("roleName"),
                    rs.getBoolean("is_active") ? "Active" : "Inactive"
                };

                users.add(user);
            }
        }

        return users;
    }

// Search users by name or username
    public List<Object[]> searchUsers(String keyword) throws SQLException {

        List<Object[]> users = new ArrayList<>();

        String sql = "SELECT u.user_ID, u.firstname, u.surname, "
                + "u.username, r.roleName, u.is_active "
                + "FROM `USER` u "
                + "INNER JOIN ROLE r ON u.role_ID = r.role_ID "
                + "WHERE u.firstname LIKE ? "
                + "OR u.surname LIKE ? "
                + "OR u.username LIKE ? "
                + "ORDER BY u.user_ID";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            String search = "%" + keyword.trim() + "%";

            pst.setString(1, search);
            pst.setString(2, search);
            pst.setString(3, search);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Object[] user = {
                        rs.getInt("user_ID"),
                        rs.getString("firstname"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getString("roleName"),
                        rs.getBoolean("is_active") ? "Active" : "Inactive"
                    };

                    users.add(user);
                }
            }
        }

        return users;
    }

// Add a new user
    public boolean addUser(String firstname, String surname,
            String username, String password, String email,
            int roleID) throws SQLException {

        String hashedPassword = BCrypt.hashpw(
                password, BCrypt.gensalt(12));

        String sql = "INSERT INTO `USER` "
                + "(role_ID, firstname, surname, username, "
                + "password_hash, email, is_active) "
                + "VALUES (?, ?, ?, ?, ?, ?, TRUE)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, roleID);
            pst.setString(2, firstname);
            pst.setString(3, surname);
            pst.setString(4, username);
            pst.setString(5, hashedPassword);
            pst.setString(6, email);

            return pst.executeUpdate() > 0;
        }
    }

// Update existing user details
    public boolean updateUser(int userID, String firstname,
            String surname, String username, String email,
            int roleID) throws SQLException {

        String sql = "UPDATE `USER` SET firstname = ?, "
                + "surname = ?, username = ?, email = ?, "
                + "role_ID = ? WHERE user_ID = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, firstname);
            pst.setString(2, surname);
            pst.setString(3, username);
            pst.setString(4, email);
            pst.setInt(5, roleID);
            pst.setInt(6, userID);

            return pst.executeUpdate() > 0;
        }
    }

// Activate or deactivate a user
    public boolean toggleUserStatus(int userID) throws SQLException {

        String sql = "UPDATE `USER` "
                + "SET is_active = NOT is_active "
                + "WHERE user_ID = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, userID);

            return pst.executeUpdate() > 0;
        }
    }

// Retrieve roles for user forms
    public List<Object[]> getAllRoles() throws SQLException {

        List<Object[]> roles = new ArrayList<>();

        String sql = "SELECT role_ID, roleName FROM ROLE ORDER BY role_ID";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                roles.add(new Object[]{
                    rs.getInt("role_ID"),
                    rs.getString("roleName")
                });
            }
        }

        return roles;
    }

    // Retrieve a specific user's details for editing
    public Object[] getUserByID(int userID) throws SQLException {

        String sql = "SELECT firstname, surname, username, email, role_ID "
                + "FROM `USER` WHERE user_ID = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, userID);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    return new Object[]{
                        rs.getString("firstname"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getInt("role_ID")
                    };
                }
            }
        }

        return null;
    }

}
