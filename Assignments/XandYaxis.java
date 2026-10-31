package Assignments;

import java.util.Scanner;

public class XandYaxis {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("\nHow many points do you want to enter? ");
        int n = input.nextInt();
        System.out.println("\n");

        double[] x = new double[n];
        double[] y = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter x-coordinate for point " + (i + 1) + ": ");
            x[i] = input.nextInt();

            System.out.print("Enter y-coordinate for point " + (i + 1) + ": " );
            y[i] = input.nextInt();

            System.out.println("\n");
        }
        
/* 
        
        int closestPoint = 0;
        double smallestDistance = x[0] * x[0] + y[0] * y[0];

      
        for (int i = 1; i < n; i++) {

            double distance = x[i] * x[i] + y[i] * y[i];

            if (distance < smallestDistance) {
                smallestDistance = distance;
                closestPoint = i;
            }
        }

        System.out.println("\nClosest point to the origin:");
        System.out.println("Point " + (closestPoint + 1)+ ": (" + x[closestPoint] + ", "+ y[closestPoint] + ")");

        input.close();
    }
}

*/