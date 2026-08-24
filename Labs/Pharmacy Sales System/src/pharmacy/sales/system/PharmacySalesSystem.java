
package pharmacy.sales.system;

import java.util.Scanner;
public class PharmacySalesSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Array Declarations
        String [][] medicine = {
                            {"1", "Paracetamol", "25.00"}, 
                            {"2", "Cough Syrup", "45.00"}, 
                            {"3", "Vitamins", "80.00"}, 
                            {"4", "Pain Relief Gel", "35.00"}, 
                            {"5", "Allergy Tablets", "30"}
        };
        
        
        //Variable Declarations 
        int item_no;
        int product_no;
        int i = 0; 
        int quantity;
        double cost = 0;
        double price;
        double subtotal = 0;
        double total = 0;
        double discount = 0.0;
        
        
        //Displaying Available Products
        System.out.println("=" .repeat(12) + " Pharmacy Sales System " + "=" .repeat(12));
        System.out.println("Product No." + " " .repeat(3) + "Product" + " " .repeat(11) + "Price (M)" + " " .repeat(3));
        for (String [] meds : medicine){
            System.out.println("\t");
            for (String item : meds){
                System.out.print("\t");
                System.out.print(item + " ");
            }
        }
        
        //Allowing the customer to select a product
        System.out.print("\nHow many products would you like to purchase? ");
        product_no = scanner.nextInt();
        
        while (i < product_no){
            System.out.print("Enter the Product No for the item you'd like to purchse: ");
            item_no = scanner.nextInt();
            
            //An array to store the purchases made
            String [][] purchases = new String [item_no][3];
            //Validating that the product number is valid.
            if (item_no < 1 && item_no > 5){
                System.out.println("Enter a product no that is within the range of products we have (1-5)!!");
            }
            
            else{
                System.out.print("\nEnter the quantity for the item number you have selected: ");
                quantity = scanner.nextInt();
                
               // Validates that the quantity is greater than zero.
                if (quantity < 0){
                    System.out.println("Enter a valid quantity number!");
                }
                
                else{
                    //Convert price from string into double
                    for (int j = 0; j < medicine.length; j++){
                        if (Integer.parseInt(medicine[j][0]) == item_no){
                            price = Double.parseDouble(medicine [j][2]);
                            cost = price * quantity;
                            subtotal += cost;
                            
                            //storing user selections in the purchases array
                            purchases[i][0] = medicine [j][1];
                            purchases[i][1] = String.valueOf(quantity);
                            purchases[i][2] = String.valueOf(subtotal);
                            
                            i++;
                        }
                    } 
                }
            }
        }
    if (subtotal > 300){
        discount = subtotal * 0.10;
        total = subtotal - discount;
    }
    //Order summary
    System.out.print("\n" + "=" . repeat(8) + "PURCHASE SUMMARY" + "=" . repeat(8));
        
    for (String[] purchase : purchases) {
        System.out.println("\nProduct: " + purchase[0]
                + "  Quantity: " + purchase[1]
                + "  Subtotal: M" + purchase[2]);
    }
    System.out.println("Total: M" + total);
            
        
        scanner.close();

    }
    
}
