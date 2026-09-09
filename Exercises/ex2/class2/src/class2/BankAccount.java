/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package class2;

public class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: M" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: M" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Display account information
    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: M" + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Tay-Tay", 5000);

        account.displayAccount();

        account.deposit(1500);
        account.withdraw(2000);

        account.displayAccount();
    }
}