/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubuntusure.dao;

/**
 *
 * @author thato
 */
import ubuntusure.config.DatabaseConnection;
import ubuntusure.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public User findByUsername(String username) throws SQLException {

        String sql = "SELECT u.user_ID, u.role_ID, u.firstname, u.surname, "
                + "u.username, u.password_hash, u.email, u.is_active, "
                + "r.roleName "
                + "FROM `USER` u "
                + "INNER JOIN ROLE r ON u.role_ID = r.role_ID "
                + "WHERE u.username = ? LIMIT 1";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username.trim());

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    User user = new User();

                    user.setUserID(resultSet.getInt("user_ID"));
                    user.setRoleID(resultSet.getInt("role_ID"));
                    user.setFirstname(resultSet.getString("firstname"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPasswordHash(
                            resultSet.getString("password_hash"));
                    user.setEmail(resultSet.getString("email"));
                    user.setActive(resultSet.getBoolean("is_active"));
                    user.setRoleName(resultSet.getString("roleName"));

                    return user;
                }
            }
        }

        return null;
    }
}
