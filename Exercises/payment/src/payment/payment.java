/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package payment;

interface Payment {

    void pay(double amount);
}

class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid M" + amount + " using credit card.");
    }
}

class CashPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid M" + amount + " using cash.");
    }
}

public class payment {
    public static void main(String[] args) {

        Payment payment1 = new CreditCardPayment();
        Payment payment2 = new CashPayment();

        payment1.pay(500);
        payment2.pay(200);
    }
}
