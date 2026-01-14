package Assignment_2.Regex_Validation;
import java.util.*;
import java.util.regex.*;

class RegexValidationDemo {

    static Scanner sc = new Scanner(System.in);

    static void validate(String input, String regex, String type) {
        try {
            if (Pattern.matches(regex, input))
                System.out.println("Welcome, valid " + type);
            else
                System.out.println("Invalid " + type);
        } catch (Exception e) {
            System.out.println("Error occurred");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println(
                "\n1.Validate Mobile Number\n2.Validate Email ID\n" +
                "3.Validate Username\n4.Validate Password\n5.Exit"
            );

            int ch;
            try {
                ch = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice");
                sc.next();
                continue;
            }

            switch (ch) {

                case 1:
                    System.out.print("Enter Mobile Number: ");
                    validate(sc.next(), "^[6-9][0-9]{9}$", "Mobile Number");
                    break;

                case 2:
                    System.out.print("Enter Email ID: ");
                    validate(sc.next(),
                            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
                            "Email ID");
                    break;

                case 3:
                    System.out.print("Enter Username: ");
                    validate(sc.next(), "^[A-Za-z0-9]{5,15}$", "Username");
                    break;

                case 4:
                    System.out.print("Enter Password: ");
                    validate(sc.next(),
                            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%!]).{8,}$",
                            "Password");
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
