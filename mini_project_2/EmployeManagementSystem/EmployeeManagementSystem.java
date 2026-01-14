package mini_project_2.EmployeManagementSystem;
import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> list = new ArrayList<>();
    static final String FILE = "employees.dat";

    static void load() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE));
            list = (ArrayList<Employee>) in.readObject();
            in.close();
        } catch (Exception e) {
        }
    }

    static void save() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE));
            out.writeObject(list);
            out.close();
        } catch (Exception e) {
        }
    }

    static boolean login() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();
        return u.equals("admin") && p.equals("admin123");
    }

    static Employee findEmployee(int id) {
        for (Employee e : list)
            if (e.getId() == id)
                return e;
        return null;
    }

    static void addEmployee() {
        try {
            System.out.print("ID: ");
            int id = sc.nextInt();
            if (findEmployee(id) != null)
                throw new InvalidEmployeeDataException("Employee ID must be unique");

            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Department: ");
            String dept = sc.next();
            if (dept.isEmpty())
                throw new InvalidEmployeeDataException("Department cannot be empty");

            System.out.print("Salary: ");
            double sal = sc.nextDouble();
            if (sal <= 0)
                throw new InvalidEmployeeDataException("Salary must be positive");

            list.add(new Employee(id, name, dept, sal));
            save();
            System.out.println("Employee Added");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void displayAll() {
        for (Employee e : list)
            e.display();
    }

    static void searchById() {
        System.out.print("Enter ID: ");
        Employee e = findEmployee(sc.nextInt());
        if (e != null)
            e.display();
        else
            System.out.println("Employee Not Found");
    }

    static void updateSalary() {
        try {
            System.out.print("Enter ID: ");
            Employee e = findEmployee(sc.nextInt());
            if (e == null)
                throw new InvalidEmployeeDataException("Employee Not Found");

            System.out.print("New Salary: ");
            double sal = sc.nextDouble();
            if (sal <= 0)
                throw new InvalidEmployeeDataException("Salary must be positive");

            e.setSalary(sal);
            save();
            System.out.println("Salary Updated");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void deleteEmployee() {
        System.out.print("Enter ID: ");
        Employee e = findEmployee(sc.nextInt());
        if (e != null) {
            list.remove(e);
            save();
            System.out.println("Employee Deleted");
        } else
            System.out.println("Employee Not Found");
    }

    static void displaySorted() {
        list.stream()
            .sorted(Comparator.comparing(Employee::getSalary))
            .forEach(Employee::display);
    }

    static void displayDepartments() {
        Set<String> set = new HashSet<>();
        for (Employee e : list)
            set.add(e.getDepartment());
        for (String d : set)
            System.out.println(d);
    }

    public static void main(String[] args) {

        load();

        if (!login()) {
            System.out.println("Invalid Login");
            return;
        }

        while (true) {
            System.out.println(
                "\n1.Add Employee\n2.Display All\n3.Search by ID\n4.Update Salary\n" +
                "5.Delete Employee\n6.Display Sorted\n7.Display Departments\n8.Exit"
            );

            int ch = sc.nextInt();

            switch (ch) {
                case 1: addEmployee(); break;
                case 2: displayAll(); break;
                case 3: searchById(); break;
                case 4: updateSalary(); break;
                case 5: deleteEmployee(); break;
                case 6: displaySorted(); break;
                case 7: displayDepartments(); break;
                case 8: System.exit(0);
                default: System.out.println("Invalid Choice");
            }
        }
    }
}
