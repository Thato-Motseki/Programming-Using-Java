/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package user.input;

/**
 *
 * @author thato
 */

import java.util.Scanner;
public class UserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.print("Enter your gpa: ");
        double gpa = scanner.nextDouble();
        
        System.out.print("Are you a student(true/false)? ");
        boolean isStudent = scanner.nextBoolean();
        
        if (isStudent){
            System.out.println ("You can check your blackboard for learning material");
        }
        else{
            System.out.println ("You are not a student!!");
        }
        
        System.out.print("\n");
        System.out.println("*" .repeat(20));
        System.out.println("Hello " + name);
        System.out.println("You are " + age + " years old!");
        System.out.println("Your gpa is " + gpa);
        System.out.println("Student: " + isStudent);
        
        
        
        scanner.close();
    }
    
}
