import java.util.Scanner;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(int accNo, String name, double initialBalance) {
        accountNumber = accNo;
        accountHolder = name;
        balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposit successful.");
    }

    // Withdraw Method
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful.");
    }

    // Balance Enquiry
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Display Account Details
    public void displayDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : ₹" + balance);
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Create Bank Account ===");
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accNo, name, balance);

        int choice;

        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depAmount = sc.nextDouble();
                        account.deposit(depAmount);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withAmount = sc.nextDouble();
                        account.withdraw(withAmount);
                        break;

                    case 3:
                        account.checkBalance();
                        break;

                    case 4:
                        account.displayDetails();
                        break;

                    case 5:
                        System.out.println("Thank you for using Bank System.");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}
