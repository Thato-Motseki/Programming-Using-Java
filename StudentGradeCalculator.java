import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter test mark: ");
        double testMark = scanner.nextDouble();

        System.out.print("Enter assignment mark: ");
        double assignmentMark = scanner.nextDouble();

        System.out.print("Enter exam mark: ");
        double examMark = scanner.nextDouble();

        double finalMark = (testMark * 0.30) + (assignmentMark * 0.20) + (examMark * 0.50);

        System.out.println("\nStudent: " + name);
        System.out.printf("Final Mark: %.2f%n", finalMark);

        if (finalMark >= 50) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }

        scanner.close();
    }
}
