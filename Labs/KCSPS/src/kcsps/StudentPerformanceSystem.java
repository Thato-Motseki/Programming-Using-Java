import java.util.Scanner;

// Superclass
class Student {
    private String name;
    private String studentNumber;

    // Constructor
    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
}

// Subclass
class ComputingStudent extends Student {
    private double programmingMark;

    // Constructor
    public ComputingStudent(String name, String studentNumber,double programmingMark) {
        super(name, studentNumber);
        this.programmingMark = programmingMark;
    }

    // Calculate final mark
    public double calculateFinalMark(double testMark) {
        return (testMark + programmingMark) / 2;
    }
}

// Main class
public class StudentPerformanceSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ask for number of students
        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();

        // Array to store student objects
        ComputingStudent[] students = new ComputingStudent[numberOfStudents];

        // Array to store test marks
        double[] testMarks = new double[numberOfStudents];

        // Input students
        for (int i = 0; i < numberOfStudents; i++) {

            System.out.println("\nStudent " + (i + 1));

            input.nextLine(); // clear newline

            System.out.print("Enter student name: ");
            String name = input.nextLine();

            System.out.print("Enter student number: ");
            String studentNumber = input.nextLine();

            // Validate test mark
            double testMark;

            do {
                System.out.print("Enter test mark (0-100): ");
                testMark = input.nextDouble();

                if (testMark < 0 || testMark > 100) {
                    System.out.println("Invalid test mark.");
                }

            } while (testMark < 0 || testMark > 100);

            // Validate programming mark
            double programmingMark;

            do {
                System.out.print("Enter programming mark (0-100): ");
                programmingMark = input.nextDouble();

                if (programmingMark < 0 || programmingMark > 100) {
                    System.out.println("Invalid programming mark.");
                }

            } while (programmingMark < 0 || programmingMark > 100);

            // Create object and store it in array
            students[i] = new ComputingStudent(
                    name,
                    studentNumber,
                    programmingMark
            );

            // Store test mark in array
            testMarks[i] = testMark;
        }

        // Variables for summary
        int passed = 0;
        int failed = 0;

        double total = 0;
        double highest = 0;

        System.out.println("\n========== RESULTS ==========");

        // Enhanced for loop
        for (int i = 0; i < students.length; i++) {

            double finalMark = students[i].calculateFinalMark(testMarks[i]);

            total += finalMark;

            if (finalMark > highest) {
                highest = finalMark;
            }

            String result;

            // Conditional statements
            if (finalMark >= 75) {
                result = "DISTINCTION";
                passed++;

            } else if (finalMark >= 50) {
                result = "PASS";
                passed++;

            } else {
                result = "FAIL - AT RISK";
                failed++;
            }

            System.out.println(
                    "Name: " + students[i].getName()
                    + " | Student No: "
                    + students[i].getStudentNumber()
                    + " | Final Mark: "
                    + finalMark
                    + " | Result: "
                    + result
            );
        }

        // Calculate average
        double average = total / students.length;

        // Class summary
        System.out.println("\n========== CLASS SUMMARY ==========");
        System.out.println("Students processed: " + students.length);
        System.out.println("Students passed: " + passed);
        System.out.println("Students failed: " + failed);
        System.out.println("Highest final mark: " + highest);
        System.out.println("Class average: " + average);

        input.close();
    }
}