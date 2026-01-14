
package Assignment_2.BankApplicaption;

public class BankApplication {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(101, "Rahul", 5000);

        try {
            account.deposit(2000);
            account.withdraw(1000);
            // account.withdraw(8000); // Uncomment to see exception
            // account.deposit(-500);  // Uncomment to see exception
        } catch (InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(account.getCustomerDetails());
    }
}
