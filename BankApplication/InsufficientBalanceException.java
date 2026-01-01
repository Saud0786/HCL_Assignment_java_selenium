package BankApplication;

//Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String message) {
     super(message);
 }
}
