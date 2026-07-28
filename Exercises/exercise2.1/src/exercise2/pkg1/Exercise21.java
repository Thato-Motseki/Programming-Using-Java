/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise2.pkg1;

/**
 *
 * @author thato
 */
public class Exercise21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**Program to output a large number amongst the 3**/
        
        int num1 = 23;
        int num2 = 78;
        int num3 = 10;
        
        if (num1 >= num2 && num1 >= num3){
            System.out.println(num1 + " is the largest between " + num2 + " and " + num3);
        }
        else if (num2 >= num1 && num2 >= num3){
            System.out.println(num2 + " is the largest between " + num1 + " and " + num3);
        }
        else{
            System.out.println(num3 + " is the largest between " + num1 + " and " + num2);
        }
              
    }
    
}
