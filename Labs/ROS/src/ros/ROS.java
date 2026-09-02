package ros;

import java.util.Scanner;

public class ROS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //variable declarations

        String menu[] = {"Burger", "Pizza", "Chicken", "Chips"};
        double prices[] = {50.00, 85.00, 70.00, 25.00};
        int item_number = 0;
        int choice = 0;
        int quantity = 0;
        double subtotal = 0.0;
        double total = 0.0;
        int invalidEntries = 0;

        do {
            System.out.println("=".repeat(8) + "MENU" + "=".repeat(8));
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i] + " ".repeat(4) + " M" + prices[i]);
            }
            System.out.print("How many items do you  want to order? ");
            choice = scanner.nextInt();

            System.out.print("Enter item Number: ");
            item_number = scanner.nextInt();

            if (item_number < 1 && item_number > 4) {
                System.out.println("Invalid Item");
                invalidEntries += 1;
            } else {
                System.out.println("Enter quantity: ");
                quantity = scanner.nextInt();

                if (quantity <= 0) {
                    System.out.println("Invalid Quantity");
                    invalidEntries += 1;
                    continue;
                }

                subtotal = quantity * prices[i];
            }

        } while (choice != 0);

        scanner.close();
    }

}
