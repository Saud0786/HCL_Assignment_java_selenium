
package Assignment_2.BankApplicaption;

interface BankingOperations {
    void deposit(double amount) throws InvalidAmountException;
    void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException;
    double getBalance();
}
