
package javaapplication37;

import java.util.Scanner;

public class JavaApplication37 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Variable initialization&Declaration
        String day;
        int CustomerNumber;
        int age = 0;
        double price = 0.0;
        double total = 0.0;
        int customers_Skipped = 0;
        double standard_ticket = 60.00;
        double subtotal = 0;
        double discount = 0;
        int i = 0;

        //Asks the user to enter the day of the week
        System.out.print("Please enter the day of the week: ");
        day = scanner.nextLine();

        //Number of customers buying tickets
        System.out.print("How many customers are buying tickets? ");
        CustomerNumber = scanner.nextInt();

        while (i < CustomerNumber) {
            System.out.print("Please enter the age for customer " + (i + 1) + ": ");
            age = scanner.nextInt();

            if (age > 1 && age < 110) {
                if (age < 13) {
                    discount = 0.5;
                    subtotal = standard_ticket - (standard_ticket * discount);
                    
                } else if (age >= 13 && age <= 17) {
                    discount = 0.25;
                    subtotal = standard_ticket - (standard_ticket * discount);
                    
                } else if (age >= 18 && age <= 64) {
                    discount = 0;
                    subtotal = standard_ticket - (standard_ticket * discount);
                    
                } else {
                    discount = 0.40;
                    subtotal = standard_ticket - (standard_ticket * discount);
                    
                }

            } else {
                System.out.println("Invalid age");
                customers_Skipped += 1;
                i++;
                continue;
                
            }
            
            switch (day){
                case "Friday":
                    System.out.print("Additional discount = M10.00");
                    price = subtotal - 10.00;
                    
                    if (price < 20){
                        price = 20.00;
                    }
                    //Display Price for each customer
                    System.out.println("\nTotal Price for customer " + (i+1) + " = M" + price +"\n\n");
                    break;
                default:
                    price = subtotal;
                    if (price < 20){
                        price = 20.00;
                    }
                    //Display Price for each customer
                    System.out.print("\nTotal Price for customer " + (i+1) + " = M" + price +"\n\n");
                    
            }
            
            i++;
            total += price;
            
        }
        System.out.println("Number of customers skipped: " + customers_Skipped);
        System.out.println("Total amount collected: M" + total);
        scanner.close();

    }

}
