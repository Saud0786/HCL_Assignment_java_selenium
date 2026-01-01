package Assignment2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexValidationApp {

    // Validate mobile number (10 digits, starts with 6-9)
    static boolean validateMobile(String mobile) {
        return Pattern.matches("[6-9][0-9]{9}", mobile);
    }

    // Validate email id
    static boolean validateEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", email);
    }

    // Validate username (5-15 chars, letters & digits only)
    static boolean validateUsername(String username) {
        return Pattern.matches("[a-zA-Z0-9]{5,15}", username);
    }

    // Validate password (min 8 chars, at least one digit & one special char)
    static boolean validatePassword(String password) {
        return Pattern.matches("(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}", password);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            try {
                System.out.println("\n--- REGEX Input Validation Menu ---");
                System.out.println("1. Validate Mobile Number");
                System.out.println("2. Validate Email ID");
                System.out.println("3. Validate Username");
                System.out.println("4. Validate Password");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {

                    case 1:
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.nextLine();
                        if (validateMobile(mobile))
                            System.out.println("Welcome! Mobile number is valid.");
                        else
                            System.out.println("Invalid mobile number.");
                        break;

                    case 2:
                        System.out.print("Enter Email ID: ");
                        String email = sc.nextLine();
                        if (validateEmail(email))
                            System.out.println("Welcome! Email ID is valid.");
                        else
                            System.out.println("Invalid email ID.");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String username = sc.nextLine();
                        if (validateUsername(username))
                            System.out.println("Welcome! Username is valid.");
                        else
                            System.out.println("Invalid username.");
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        String password = sc.nextLine();
                        if (validatePassword(password))
                            System.out.println("Welcome! Password is valid.");
                        else
                            System.out.println("Invalid password.");
                        break;

                    case 5:
                        System.out.println("Thank you! Program exited.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter correct data.");
                sc.nextLine();
            }
        }
    }
}
