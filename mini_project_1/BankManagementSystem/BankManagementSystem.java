package mini_project_1.BankManagementSystem;
import java.io.*;
import java.util.*;

public class BankManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static final String FILE = "accounts.dat";

    static void load() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE));
            accounts = (ArrayList<BankAccount>) in.readObject();
            in.close();
        } catch (Exception e) {
        }
    }

    static void save() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE));
            out.writeObject(accounts);
            out.close();
        } catch (Exception e) {
        }
    }

    static BankAccount findAccount(int accNo) {
        for (BankAccount a : accounts)
            if (a.getAccNo() == accNo)
                return a;
        return null;
    }

    static void createAccount() {
        System.out.print("Account No: ");
        int accNo = sc.nextInt();

        if (findAccount(accNo) != null) {
            System.out.println("Account already exists");
            return;
        }

        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Balance: ");
        double bal = sc.nextDouble();
        System.out.print("1.Savings  2.Current: ");
        int type = sc.nextInt();

        BankAccount acc;
        if (type == 1)
            acc = new SavingsAccount(accNo, name, bal);
        else
            acc = new CurrentAccount(accNo, name, bal);

        accounts.add(acc);
        save();
        System.out.println("Account Created");
    }

    static void deposit() {
        System.out.print("Account No: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account Not Found");
            return;
        }

        System.out.print("Amount: ");
        acc.deposit(sc.nextDouble());
        save();
    }

    static void withdraw() {
        System.out.print("Account No: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account Not Found");
            return;
        }

        System.out.print("Amount: ");
        acc.withdraw(sc.nextDouble());
        save();
    }

    static void balanceEnquiry() {
        System.out.print("Account No: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);

        if (acc != null)
            System.out.println("Balance: " + acc.getBalance());
        else
            System.out.println("Account Not Found");
    }

    static void displayAccount() {
        System.out.print("Account No: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);

        if (acc != null)
            acc.display();
        else
            System.out.println("Account Not Found");
    }

    public static void main(String[] args) {

        load();

        while (true) {
            System.out.println(
                "\n1.Create Account\n2.Deposit\n3.Withdraw\n4.Balance Enquiry\n5.Display Account\n6.Exit"
            );

            int ch = sc.nextInt();

            switch (ch) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: balanceEnquiry(); break;
                case 5: displayAccount(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid Choice");
            }
        }
    }
}
