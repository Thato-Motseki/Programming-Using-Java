/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prepaid.meter;

public class PrepaidMeter {
    private String meterNumber;
    private double units;

    public PrepaidMeter(String meterNumber) {
        this.meterNumber = meterNumber;
        this.units = 0;
    }

    public void addUnits(double amount) {
        units += amount;
    }

    public void consume(double amount) {
        if (amount <= units) {
            units -= amount;
        } else {
            System.out.println("Insufficient units.");
        }
    }

    public double getUnits() {
        return units;
    }
}