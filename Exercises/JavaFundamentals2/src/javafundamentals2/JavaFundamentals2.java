
package javafundamentals2;

import java.util.Scanner;
import java.util.Collection;

public class JavaFundamentals2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        //QUESTION 6
        
        int [] stats = {12, 7, 25, 18, 30, 9, 14};
        
        int sum = 0;
        int average;
        int largest = stats[0];
        int smallest = stats[0];
        
        for (int i = 0; i < stats.length; i++){
            sum += stats[i];
            
            if (stats[i] >= largest){
                largest = stats[i];
            }
            
            if (stats[i] <= smallest){
                smallest = stats[i];
            }
        }
        average = sum/stats.length;
        System.out.println("Average: " + average);
        System.out.println("Largest is: " + largest);
        System.out.println("Smallest is: " + smallest);
        
        //QUESTION 7
        System.out.print("\n");
        System.out.println("Question 7:");
        
        int[] numbers = {4, 7, 12, 9, 16, 21, 8, 5};
        int even = 0;
        int odd = 0;
        
        for (int number : numbers){
            if (number % 2 == 0){
                even ++;
            } else{
                odd++;
            }
        }
        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
        
        //QUESTION 8
        
        scanner.close();
        
        
    }

}
