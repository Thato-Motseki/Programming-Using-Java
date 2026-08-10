/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array.traversal;

import java.util.Scanner;
public class ArrayTraversal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        //Array declaration
        String [] foods = new String [2];
        
        //Taking user input for the array
        System.out.print("*" .repeat(5) + "FOODS" + "*" .repeat(5) + "\n");
        for (int i = 0; i < foods.length; i++){
            System.out.print ("Enter food: ");
            foods[i] = scanner.nextLine();
        }
        
        //Printing user-created array
        for (String food : foods){
            System.out.print("Array of foods: " + food + " ");
            
        }
        
        //User declared size
        System.out.print("\n\n" + "*" .repeat(5) + "VEGGIES" + "*" .repeat(5)+ "\n");
        String [] Veggies;
        int size;
        
        System.out.print("What # of veggies do you want to add? ");
        size = scanner.nextInt();
        scanner.nextLine();
        
        Veggies = new String [size];
        
        
        for (int i = 1; i <= Veggies.length; i++){
            System.out.print("Enter veggie " + i + ": " );
            Veggies[i] = scanner.nextLine();
            
        }
        
        for (String veggie : Veggies){
            System.out.print("Array of veggies: " + veggie + " ");
            
        }
        
        //Telephone Array
        System.out.print("\n\n" + "*" .repeat(5) + "TELEPHONE" + "*" .repeat(5)+ "\n");
        char [][] telephone = {
                               {'1', '2', '3'},
                               {'4', '5', '6'}, 
                               {'7', '8', '9'}, 
                               {'*', '0', '#'}
        };
        
        for (char [] row : telephone){
            for (char number : row){
                System.out.print(number + " ");
            }
            System.out.println();
                   
        }
        
    }
    
}
