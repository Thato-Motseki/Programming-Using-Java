/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ubuntusure.service;
/**
 *
 * @author thato
 */

import ubuntusure.dao.UserDAO;
import ubuntusure.model.User;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class AuthenticationService {

    private final UserDAO userDAO;

    public AuthenticationService() {
        this.userDAO = new UserDAO();
    }

    public User authenticate(String username, char[] password)
            throws SQLException {

        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Please enter your username.");
        }

        if (password == null || password.length == 0) {
            throw new IllegalArgumentException(
                    "Please enter your password.");
        }

        User user = userDAO.findByUsername(username.trim());

        if (user == null) {
            return null;
        }

        if (!user.isActive()) {
            return null;
        }

        String storedHash = user.getPasswordHash();

        if (storedHash == null
                || !BCrypt.checkpw(new String(password), storedHash)) {
            return null;
        }

        return user;
    }
}

