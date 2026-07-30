/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rectanglecalculator;

import java.util.Scanner;

/**
 * @author thato
 */
public class RectangleCalculator {

    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Prompt user for values
        System.out.print("Enter the length of the rectangle: ");
        double length = input.nextDouble();

        System.out.print("Enter the width of the rectangle: ");
        double width = input.nextDouble();

        // Calculate area and perimeter
        double area = length * width;
        double perimeter = 2 * (length + width);

        // Display results
        System.out.println("\n----------------- Results -----------------");
        System.out.printf("Area of the rectangle: %.2f square units%n", area);
        System.out.printf("Perimeter of the rectangle: %.2f units%n", perimeter);

        input.close();
    }  
}
