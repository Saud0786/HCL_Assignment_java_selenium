package BankManagementSystem;

import java.io.*;

//Abstract class (Abstraction)
public abstract class BankAccount {

 // Encapsulation
 private int accountNo;
 private String name;
 protected double balance;

 // Constructor
 public BankAccount(int accountNo, String name, double balance) {
     this.accountNo = accountNo;
     this.name = name;
     this.balance = balance;
 }

 // Deposit money
 public void deposit(double amount) {
     if (amount > 0)
         balance += amount;
 }

 // Method overloading
 public void deposit(int amount) {
     deposit((double) amount);
 }

 // Withdraw money
 public void withdraw(double amount) {
     if (amount <= balance)
         balance -= amount;
     else
         System.out.println("Insufficient balance.");
 }

 // Show account details
 public void showDetails() {
     System.out.println("Account No : " + accountNo);
     System.out.println("Name       : " + name);
     System.out.println("Balance    : " + balance);
 }

 // Abstract method
 public abstract void accountType();

 // File storage data
 public String getFileData() {
     return accountNo + "," + name + "," + balance + "," +
            getClass().getSimpleName();
 }
}
