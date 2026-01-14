package mini_project_1.BankManagementSystem;
import java.io.Serializable;

public abstract class BankAccount implements Serializable {

    private int accNo;
    private String name;
    protected double balance;

    public BankAccount(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) {
        if (amt <= balance)
            balance -= amt;
        else
            System.out.println("Insufficient Balance");
    }

    public void display() {
        System.out.println(accNo + " " + name + " " + balance);
    }

    public abstract void calculateInterest();
}
