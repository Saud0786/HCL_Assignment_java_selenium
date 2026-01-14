
package Assignment_2.StudentRecordManagement;
import java.util.*;
import java.util.regex.Pattern;

public class StudentRecordApp {

    // REGEX validation for email
    static boolean validateEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", email);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentOperations manager = new StudentManager();

        while (true) {
            try {
                System.out.println("\n--- Student Record Menu ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Remove Student by Roll No");
                System.out.println("4. Search Student by Roll No");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Roll No: ");
                        int roll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        if (!validateEmail(email)) {
                            System.out.println("Invalid email format.");
                            break;
                        }

                        manager.addStudent(new Student(roll, name, email));
                        break;

                    case 2:
                        manager.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter Roll No to remove: ");
                        manager.removeStudent(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter Roll No to search: ");
                        manager.searchStudent(sc.nextInt());
                        break;

                    case 5:
                        System.out.println("Program exited.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter correct data.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}
