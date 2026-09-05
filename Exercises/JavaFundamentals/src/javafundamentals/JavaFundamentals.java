package javafundamentals;

import java.util.Scanner;

public class JavaFundamentals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // QUESTION 1 

        System.out.println("Question 1: ");

        int mathMark = 75;
        int csMark = 82;
        int engMark = 68;

        int total = mathMark + engMark + csMark;
        double average = total / 3;

        System.out.println("Total marks: " + total);
        System.out.println("Average mark: " + average);

        // QUESTION 2
        System.out.print("\n");
        System.out.print("Question 2: ");

        System.out.print("\nEnter a number: ");
        int number = scanner.nextInt();

        String result = (number % 2 == 0) ? "Even" : "Odd";

        System.out.println(result);

        //QUESTION 3
        System.out.print("\n");
        System.out.print("Question 3: ");

        System.out.print("\n Enter a number 1: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter a number 2: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter a number 3: ");
        int num3 = scanner.nextInt();

        int largest = (num1 >= num2 ? ((num1 >= num3) ? num1 : num3) : ((num2 >= num3) ? num2 : num3));

        System.out.println("Largest number: " + largest);

        //QUESTION 4
        System.out.print("\n");
        System.out.print("Question 4: ");

        System.out.print("\n Enter the student's mark: ");
        int mark = scanner.nextInt();
        char grade;

        if (mark >= 80 && mark <= 100) {
            grade = 'A';
        } else if (mark >= 70) {
            grade = 'B';
        } else if (mark >= 60) {
            grade = 'C';
        } else if (mark >= 50) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.print("Grade: " + grade);
        if (mark >= 50) {
            System.out.println("\nPass");
        } else {
            System.out.print("Fail");
        }

        //QUESTION 5
        System.out.print("\n");
        System.out.print("Question 5: ");

        System.out.print("Enter a number: ");
        int multiplication = scanner.nextInt();
        int product;

        for (int i = 1; i <= 12; i++) {
            product = multiplication * i;
            System.out.print(multiplication + " x " + i + " = " + product);
            System.out.println(" ");
        }
    }
}
