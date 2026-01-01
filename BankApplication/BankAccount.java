package BankApplication;

//BankAccount class implementing multiple interfaces
class BankAccount implements BankingOperations, CustomerOperations {

 // Encapsulation: private data
 private int accountNumber;
 private String customerName;
 private double balance;

 // Constructor
 public BankAccount(int accountNumber, String customerName, double balance) {
     this.accountNumber = accountNumber;
     this.customerName = customerName;
     this.balance = balance;
 }

 // Deposit money
 @Override
 public void deposit(double amount) throws InvalidAmountException {
     if (amount <= 0) {
         throw new InvalidAmountException("Deposit amount must be greater than zero");
     }
     balance += amount;
 }

 // Withdraw money
 @Override
 public void withdraw(double amount)
         throws InsufficientBalanceException, InvalidAmountException {

     if (amount <= 0) {
         throw new InvalidAmountException("Withdrawal amount must be greater than zero");
     }
     if (amount > balance) {
         throw new InsufficientBalanceException("Insufficient balance");
     }
     balance -= amount;
 }

 // Return balance
 @Override
 public double getBalance() {
     return balance;
 }

 // Update customer name
 @Override
 public void updateCustomerName(String name) {
     this.customerName = name;
 }

 // Return customer details
 @Override
 public String getCustomerDetails() {
     return "Account No: " + accountNumber +
            ", Name: " + customerName +
            ", Balance: " + balance;
 }
}