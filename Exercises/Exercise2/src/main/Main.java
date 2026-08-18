
package main;

//class vehicle together with its fields
class Vehicle {

    String brand;
    int speed;

    // Constructor
    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Method
    void describe() {
        System.out.println(brand + " travels at " + speed + " km/h");
    }
}

class Car extends Vehicle {

    int doors;

    // Constructor
    Car(String brand, int speed, int doors) {
        super(brand, speed);
        this.doors = doors;
    }

    // Overriding describe()
    @Override
    void describe() {
        super.describe();
        System.out.println("and has " + doors + " doors");
    }
}

class SportsCar extends Car {

    boolean turboEnabled;

    // Constructor
    SportsCar(String brand, int speed, int doors, boolean turboEnabled) {
        super(brand, speed, doors);
        this.turboEnabled = turboEnabled;
    }

    // Overriding describe()
    @Override
    void describe() {
        super.describe();

        if (turboEnabled) {
            System.out.println("[TURBO]");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        // Create Vehicle object
        Vehicle vehicle = new Vehicle("Toyota", 120);

        // Create Car object
        Car car = new Car("BMW", 180, 4);

        // Create SportsCar object
        SportsCar sportsCar = new SportsCar("Ferrari", 300, 2, true);

        // Call describe() on all three
        vehicle.describe();

        System.out.println();

        car.describe();

        System.out.println();

        sportsCar.describe();
    }
}

