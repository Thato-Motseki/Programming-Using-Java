/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banking.system;
import java.util.Scanner;

/**
 *
 * @author thato
 */
public class BankingSystem {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner (System.in);
        
        //variable declarations:
        final String Stored_Username = "Admin_User";
        final String Stored_Password = "Pass@123";
        int attempts = 0;
        int maxAttempts = 3;
        boolean lockedOut = false;
        
        while (attempts < maxAttempts){
            System.out.print("Enter your Username: ");
            String username = input.next();
        
            System.out.print("Enter your password: ");
            String password = input.next();
            
            boolean isAuthenticated = username.equals(Stored_Username) && password.equals(Stored_Password);
            
            if (!isAuthenticated){
                attempts++;
                System.out.println("Attemts Remaining: " + (maxAttempts-attempts));
            }
            else {
                System.out.println("Access granted!");
                break;
            }
            
        if (attempts == maxAttempts){
            System.out.println("Account locked, max attempts reached.");
        }
            
        }
        
    }    
}
