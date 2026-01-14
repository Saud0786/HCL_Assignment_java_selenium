package mini_project_1.BankManagementSystem;
public class SavingsAccount extends BankAccount {

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void calculateInterest() {
        balance += balance * 0.04;
    }
}
