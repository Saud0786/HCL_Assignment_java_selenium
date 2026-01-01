package BankManagementSystem;

//CurrentAccount class
public class CurrentAccount extends BankAccount {

 public CurrentAccount(int accNo, String name, double balance) {
     super(accNo, name, balance);
 }

 @Override
 public void accountType() {
     System.out.println("Account Type: Current Account");
 }
}
