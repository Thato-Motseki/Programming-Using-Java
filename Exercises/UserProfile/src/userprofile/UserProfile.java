/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package userprofile;

/**
 *
 * @author thato
 */
public class UserProfile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare variables with appropriate data types
        String firstName = "Thato";
        int age = 18;
        double heightInMeters = 1.68;
        boolean isActiveSubscriber = true;
        String favoriteColor = "Dark White";

        // Print output
        System.out.println("=========== User Profile =========== \n");
        System.out.println("First Name: " + firstName);
        System.out.println("Age: " + age);
        System.out.println("Height (m): " + heightInMeters);
        System.out.println("Active Subscriber: " + isActiveSubscriber);
        System.out.println("Favorite Color: " + favoriteColor);
    }
}
