/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise2.pkg3;

/**
 *
 * @author thato
 */
public class Exercise23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**Program to output the second names in an array**/
        String [] names = {"Thabo", "Thato", "Lineo","Mpho", "Rorisang", "Hlony","Retha"};
        int n = names.length; /**n is the length of the array**/
        
        for (int i = 1; i < n; i += 2){
            System.out.print(names[i] + " ");
        }
    }
    
}
