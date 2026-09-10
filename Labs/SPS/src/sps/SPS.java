package sps;

import java.util.Scanner;

class Student {

    private String name;
    private int studentNumber;

    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
}

class ComputingStudent extends Student {

    private int programmingMark;

    public ComputingStudent(String name, int studentNumber, int programmingMark) {
        super(name, studentNumber);
        this.programmingMark = programmingMark;
    }

    public double calculateFinalMark() {
        return (testMark + programmingMark) / 2;
    }
}

public class SPS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many students do you want to store? ");
        int number = scanner.nextInt();

        ComputingStudent[] students = new ComputingStudent[number];

        double[] testMarks = new double[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1) + ": ");

            System.out.println("Enter student " + (i + 1) + "'s name: ");
            String name = scanner.nextLine();

            System.out.println("Enter student " + (i + 1) + "'s student number: ");
            String studentNumber = scanner.nextLine();

            double testMark;
            double programmingMark;
            
            //validating test marks
            do {
                System.out.println("Enter student " + (i + 1) + "'s test mark: ");
                testMark = scanner.nextDouble();
                
                if (testMark < 0 || testMark > 100){
                    System.out.println("Invalid Mark!");
                }
            }while (testMark < 0 || testMark > 100);
            
            //validating programming marks
            do {
                System.out.println("Enter student " + (i + 1) + "'s programming mark (0-100): ");
                programmingMark = scanner.nextDouble();
                
                if (programmingMark < 0 || programmingMark > 100){
                    System.out.println("Invalid Mark!");
                }
            }while (programmingMark < 0 || programmingMark > 100);
            
            
        }

        scanner.close();
    }

}
