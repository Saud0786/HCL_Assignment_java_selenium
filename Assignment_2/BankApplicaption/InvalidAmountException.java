package Assignment_2.BankApplicaption;

//Custom exception for invalid amount
class InvalidAmountException extends Exception {
 public InvalidAmountException(String message) {
     super(message);
 }
}