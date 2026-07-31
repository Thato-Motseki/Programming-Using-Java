/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex4;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a word: ");
        String word = input.nextLine();
        
        // Convert both to same case so case doesn't matter
        String original = word.toLowerCase();
        String reversed = new StringBuilder(original).reverse().toString();
        
        if (original.equals(reversed)) {
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is NOT a palindrome");
        }
        input.close();
    }  
}
