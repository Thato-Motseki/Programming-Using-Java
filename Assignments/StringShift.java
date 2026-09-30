package Assignments;

import java.util.Scanner;

public class StringShift {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter A: ");
        String A = input.nextLine();

        System.out.print("Enter B: ");
        String B = input.nextLine();

        if (A.length() != B.length()) {
            System.out.println("false");
            return;
        }

        String current = A;

        for (int i = 0; i < A.length(); i++) {

            System.out.println("\nShift " + i + ": " + current);

            if (current.equals(B)) {
                System.out.println("\nB was found after " + i + " shifts.");
                System.out.println("B = " + B + "\n");
                break;
            }

            
            current = current.substring(1) + current.charAt(0);
        }

        input.close();
    }
}