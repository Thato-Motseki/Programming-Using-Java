/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package enhanced.pkgfor.loop;

/**
 *
 * @author thato
 */

import java.util.Arrays;
public class EnhancedForLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fruits [] = {"Banana", "Apple", "Orange", "Strawberry", "Coconut"};
        
        //Enhanced for loop vs normal for loop
        for (String fruit : fruits){
            System.out.print(fruit + " ");
        }
        
        System.out.print("\n");
        
        //Normal for loop + sorted array
        Arrays.sort(fruits);
        for (int i =0; i < fruits.length; i++){
            System.out.print(fruits[i] + " ");
        }
        
    }
    
}
