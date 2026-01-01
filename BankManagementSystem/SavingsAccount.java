package BankManagementSystem;

//SavingsAccount class
public class SavingsAccount extends BankAccount {

 public SavingsAccount(int accNo, String name, double balance) {
     super(accNo, name, balance);
 }

 // Method overriding
 @Override
 public void accountType() {
     System.out.println("Account Type: Savings Account");
 }
 
}
