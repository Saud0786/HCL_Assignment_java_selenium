package BankApplication;

interface BankingOperations {
    void deposit(double amount) throws InvalidAmountException;
    void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException;
    double getBalance();
}