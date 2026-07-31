/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex3;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first text: ");
        String text1 = input.nextLine();
        
        System.out.print("Enter second text: ");
        String text2 = input.nextLine();
        
        // Use equals() for content comparison
        if (text1.equals(text2)) {
            System.out.println("They are the same");
        } else {
            System.out.println("Nahhh");
        }
        input.close();
    }
    
}
