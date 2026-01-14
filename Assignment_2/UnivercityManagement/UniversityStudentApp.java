
package Assignment_2.UnivercityManagement;
import java.util.*;
import java.util.regex.Pattern;

public class UniversityStudentApp {

    // REGEX validation for name and course
    static boolean validateText(String text) {
        return Pattern.matches("[A-Za-z ]+", text);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UniversityOperations manager = new UniversityManager();

        while (true) {
            try {
                System.out.println("\n--- University Student Menu ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Remove Student by ID");
                System.out.println("4. Search Student by ID");
                System.out.println("5. Sort Students by Marks");
                System.out.println("6. Convert HashMap to TreeMap");
                System.out.println("7. Count Students Course-wise");
                System.out.println("8. Display All Courses");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        if (!validateText(name)) {
                            System.out.println("Invalid name.");
                            break;
                        }

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();
                        if (!validateText(course)) {
                            System.out.println("Invalid course.");
                            break;
                        }

                        System.out.print("Enter Marks: ");
                        int marks = sc.nextInt();

                        manager.addStudent(
                            new Student(id, name, course, marks));
                        break;

                    case 2:
                        manager.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        manager.removeStudent(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter ID: ");
                        manager.searchStudent(sc.nextInt());
                        break;

                    case 5:
                        manager.sortByMarks();
                        break;

                    case 6:
                        ((UniversityManager) manager).convertToTreeMap();
                        break;

                    case 7:
                        manager.countCourseWise();
                        break;

                    case 8:
                        manager.displayCourses();
                        break;

                    case 9:
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
