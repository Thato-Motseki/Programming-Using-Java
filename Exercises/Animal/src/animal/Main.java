package animal;

abstract class Animal {

    // Abstract method: subclasses MUST provide their own implementation
    abstract void makeSound();

    // Concrete method: already implemented
    void sleep() {
        System.out.println("Animal is sleeping...");
    }
}

class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Dog says: Woof!");
    }
}

public class Main {
    public static void main(String[] args) {

        Animal myDog = new Dog();

        myDog.makeSound();
        myDog.sleep();
    }
}