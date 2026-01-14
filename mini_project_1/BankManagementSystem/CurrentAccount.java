package mini_project_1.BankManagementSystem;
public class CurrentAccount extends BankAccount {

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void calculateInterest() {
    }
}
