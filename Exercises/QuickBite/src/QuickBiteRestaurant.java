import java.util.Scanner;

/**
 *
 * @author thato
 */
public class QuickBiteRestaurant {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[][] menu = {
                {"Burger", "65"},
                {"Pizza", "90"},
                {"Chicken Wrap", "75"},
                {"Fries", "40"}
        };

        System.out.println("====== QUICKBITE MENU ======\n");

        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i][0] + " - M" + menu[i][1]);
        }

        System.out.print("\nEnter Customer Name: ");
        String customer = input.nextLine();

        System.out.print("Select Meal (1-4): ");
        int choice = input.nextInt();

        if (choice < 1 || choice > menu.length) {
            System.out.println("Invalid meal selection.");
            return;
        }

        System.out.print("Enter Quantity: ");
        int quantity = input.nextInt();
        input.nextLine(); // Consume newline

        System.out.print("Enter Day of the Week: ");
        String day = input.nextLine();

        String meal = menu[choice - 1][0];
        int price = Integer.parseInt(menu[choice - 1][1]);

        double subtotal = price * quantity;
        double discountRate = 0;

        if (day.equalsIgnoreCase("Monday")) {
            discountRate = 0.10;
        } else if (day.equalsIgnoreCase("Wednesday")) {
            discountRate = 0.15;
        } else if (day.equalsIgnoreCase("Friday")) {
            discountRate = 0.20;
        }

        double discount = subtotal * discountRate;
        double total = subtotal - discount;

        System.out.println("\n==============================");
        System.out.println("     QUICKBITE RECEIPT");
        System.out.println("==============================");
        System.out.println("Customer : " + customer);
        System.out.println();
        System.out.println("Meal      : " + meal);
        System.out.println("Price     : M" + price);
        System.out.println("Quantity  : " + quantity);
        System.out.println();
        System.out.println("Subtotal  : M" + subtotal);
        System.out.println("Discount  : M" + discount);
        System.out.println("Total     : M" + total);
        System.out.println();
        System.out.println("Thank you for dining with us!");
        System.out.println("==============================");

        input.close();
    }
}
