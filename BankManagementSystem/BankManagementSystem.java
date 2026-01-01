package BankManagementSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BankManagementSystem {

    static final String FILE_NAME = "bankdata.txt";

    // Save data to file
    static void saveToFile(BankAccount acc) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(acc.getFileData() + "\n");
        } catch (IOException e) {
            System.out.println("File error.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();

                    System.out.print("1. Savings  2. Current: ");
                    int type = sc.nextInt();

                    // Runtime polymorphism
                    if (type == 1)
                        account = new SavingsAccount(accNo, name, bal);
                    else
                        account = new CurrentAccount(accNo, name, bal);

                    saveToFile(account);
                    System.out.println("Account created successfully.");
                    break;

                case 2:
                    if (account != null) {
                        System.out.print("Enter amount: ");
                        account.deposit(sc.nextDouble());
                    } else
                        System.out.println("Create account first.");
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("Enter amount: ");
                        account.withdraw(sc.nextDouble());
                    } else
                        System.out.println("Create account first.");
                    break;

                case 4:
                    if (account != null)
                        System.out.println("Balance: " + account.balance);
                    else
                        System.out.println("Create account first.");
                    break;

                case 5:
                    if (account != null) {
                        account.accountType();
                        account.showDetails();
                    } else
                        System.out.println("Create account first.");
                    break;

                case 6:
                    System.out.println("Thank you.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
