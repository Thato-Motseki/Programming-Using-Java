package Assignments;

import java.util.Scanner;

public class StringShift1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter string A: ");
        String A = input.nextLine();

        System.out.print("Enter string B: ");
        String B = input.nextLine();

        if (A.length() != B.length()) {
            System.out.println("\nfalse");
        } else {
            String combined = A + A;

            if (combined.contains(B)) {
                System.out.println("\ntrue");
            } else {
                System.out.println("\nfalse");
            }
        }

        input.close();
    }
}