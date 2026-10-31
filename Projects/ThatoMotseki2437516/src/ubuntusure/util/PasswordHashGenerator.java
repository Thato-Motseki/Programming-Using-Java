/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ubuntusure.util;
/**
 *
 * @author thato
 */

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashGenerator {

public static void main(String[] args) {
    String password = "1234";

    String hashedPassword = BCrypt.hashpw(
            password,
            BCrypt.gensalt(12)
    );

    System.out.println("BCrypt password hash:");
    System.out.println(hashedPassword);
}


}

