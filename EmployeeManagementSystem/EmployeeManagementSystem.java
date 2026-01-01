package EmployeeManagementSystem;
import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {

    // Simple login system
    static boolean login(Scanner sc) {
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        return user.equals("admin") && pass.equals("admin123");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("---- Employee Management Login ----");
        if (!login(sc)) {
            System.out.println("Invalid login credentials.");
            return;
        }

        EmployeeManager manager = new EmployeeManager();

        while (true) {
            try {
                System.out.println("\n1. Add Employee");
                System.out.println("2. Display All Employees");
                System.out.println("3. Search Employee by ID");
                System.out.println("4. Update Employee Salary");
                System.out.println("5. Delete Employee");
                System.out.println("6. Display Sorted Employees");
                System.out.println("7. Display Departments");
                System.out.println("8. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Department: ");
                        String dept = sc.nextLine();

                        manager.addEmployee(new Employee(id, name, salary, dept));
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
                        int uid = sc.nextInt();
                        System.out.print("New Salary: ");
                        double ns = sc.nextDouble();
                        manager.updateSalary(uid, ns);
                        break;

                    case 5:
                        System.out.print("Enter ID: ");
                        manager.deleteEmployee(sc.nextInt());
                        break;

                    case 6:
                        manager.displaySortedEmployees();
                        break;

                    case 7:
                        manager.displayDepartments();
                        break;

                    case 8:
                        System.out.println("System exited.");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input type.");
                sc.nextLine();
            } catch (ValidationException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}