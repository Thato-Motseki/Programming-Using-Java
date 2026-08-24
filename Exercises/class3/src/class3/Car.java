/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package class3;

public class Car {
    private String brand;
    private String model;
    private int year;
    private boolean engineOn;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineOn = false;
    }

    // Start the car
    public void startEngine() {
        if (!engineOn) {
            engineOn = true;
            System.out.println("The engine has started.");
        } else {
            System.out.println("The engine is already running.");
        }
    }

    // Stop the car
    public void stopEngine() {
        if (engineOn) {
            engineOn = false;
            System.out.println("The engine has stopped.");
        } else {
            System.out.println("The engine is already off.");
        }
    }

    // Display car information
    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine On: " + engineOn);
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2022);

        car.displayDetails();

        car.startEngine();
        car.startEngine();

        car.stopEngine();

        car.displayDetails();
    }
}