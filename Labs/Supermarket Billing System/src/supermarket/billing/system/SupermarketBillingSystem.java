
package supermarket.billing.system;

import java.util.Scanner;

public class SupermarketBillingSystem {


    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        //variable declarations
        String [][] products = {
                                {"1", "Bread", "18.00"}, 
                                {"2", "Milk", "16.00"}, 
                                {"3", "Cereal", "42.00"}, 
                                {"4", "Chicken", "75.00"}, 
                                {"5", "Juice", "25.00"}
        };
        double subtotal = 0;
        double total = 0;
        double discount;
        double total_price =0;
        double price;        
        
        System.out.println("*" .repeat(7) + "Super Market Checkout Calculator" + "*" .repeat(7));
        System.out.println("Item #" + " ".repeat(2) + "Product " + " ".repeat(1) + "Price (M)"); 
        for (String [] product : products){
            System.out.print("\t");
            for (String item : product){
                System.out.print(item + " ");
            }
            System.out.println();
        } 
        
        System.out.print("How many items do you want to buy? ");
        int item_number = scanner.nextInt();
        String[][] purchases = new String[item_number][3];
        int i = 0;
        
        if (item_number == 0){
            System.out.print("Thank you for using our system!");
        }
        
        while (i < item_number){
            
            //Taking item number 
            System.out.print("Enter Item number you want to add: ");
            int order_num = scanner.nextInt();
            
            if (order_num >= 1 && order_num <= 5){
                
                //Taking quantity
                System.out.print("How many of those would you like? ");
                int quantity = scanner.nextInt();
                
                //Coverting Price into a double
                for (int k = 0; k < products.length; k++){
                    if (Integer.parseInt(products[k][0]) == order_num){
                        
                        price = Double.parseDouble(products[k][2]);
                        
                        if (quantity < 0 || quantity == 0){
                            System.out.print("Invalid quantity number!");
                        }
                        else{
                            subtotal = price * quantity;
                            total += subtotal;
                            
                            //Storing the user items in a second, empty array
                            purchases[i][0] = products[k][1]; //product name
                            purchases[i][1] = String.valueOf(quantity);//quantity converted to string
                            purchases[i][2] = String.valueOf(subtotal); //subtotal converted to string

                            i++;
                        } 
                    }
                }
            }
            //if order number < 1 or > 5
            else{
                System.out.print("Invalid item number!");
            }  
            
        }
        //calculating discount and total price
        if (total > 300){
            discount = total * 0.10;
            total_price = total - discount;
        }
        else if (total >= 20 && total <= 300){
            total_price = total;
        }
        else{
            total_price = 20.00;
        }

        //Order summary
        System.out.print("\n" + "=" . repeat(5) + "ORDER SUMMARY" + "=" . repeat(5));
        for (String[] purchase : purchases) {
            System.out.println("\nProduct: " + purchase[0]
                    + "  Quantity: " + purchase[1]
                    + "  Subtotal: M" + purchase[2]);
        }
        System.out.println("Total: M" + total_price);
        
        scanner.close();
    }
}
