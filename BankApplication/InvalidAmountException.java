package BankApplication;

//Custom exception for invalid amount
class InvalidAmountException extends Exception {
 public InvalidAmountException(String message) {
     super(message);
 }
}