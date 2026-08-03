/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex7;

/**
 *
 * @author thato
 */
public class Ex7 {

    public static void main(String[] args) {
        String[] array1 = {"Apple", "Banana", "Orange", "Mango", "Pear"};
        String[] array2 = {"Grapes", "Orange", "Banana", "Kiwi", "Pear"};

        System.out.println("Common elements:");

        for (String array11 : array1) {
            for (String array21 : array2) {
                if (array11.equalsIgnoreCase(array21)) {
                    System.out.println(array11);
                }
            }
        }
    }
}
