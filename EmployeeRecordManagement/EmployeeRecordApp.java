package EmployeeRecordManagement;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class EmployeeRecordApp {

    // REGEX email validation
    static boolean validateEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", email);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        while (true) {
            try {
                System.out.println("\n--- Employee Menu ---");
                System.out.println("1. Add Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Search Employee");
                System.out.println("4. Remove Employee");
                System.out.println("5. Null Support Demo");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        if (!validateEmail(email)) {
                            System.out.println("Invalid email format.");
                            break;
                        }

                        manager.addEmployee(new Employee(id, name, email));
                        break;

                    case 2:
                        manager.displayEmployees();
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        manager.searchEmployee(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter ID: ");
                        manager.removeEmployee(sc.nextInt());
                        break;

                    case 5:
                        manager.demonstrateNullSupport();
                        break;

                    case 6:
                        System.out.println("Program exited.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}
