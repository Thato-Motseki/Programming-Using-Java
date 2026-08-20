/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rectangle;

public class Rectangle {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    // returns a value, takes no parameters
    public double area() {
        return width * height;
    }
    
    // returns a value, takes a parameter
    public boolean isLargerThan(Rectangle other) {
        return this.area() > other.area();
    }
    // returns nothing (void), takes parameters
    public void resize(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }
    // static — belongs to the CLASS, not any one Rectangle
    public static Rectangle unitSquare() {
        return new Rectangle(1.0, 1.0);
    }
}