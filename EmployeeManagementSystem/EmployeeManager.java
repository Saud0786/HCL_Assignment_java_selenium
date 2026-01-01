package EmployeeManagementSystem;
import java.util.*;
import java.io.*;

class EmployeeManager {

    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private Set<String> departments = new HashSet<>();
    private final String FILE = "employees.txt";

    public EmployeeManager() {
        loadFromFile();
    }

    // Load data from file
    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                Employee e = Employee.fromString(line);
                employeeMap.put(e.getId(), e);
                departments.add(e.getDepartment());
            }
        } catch (IOException ignored) {}
    }

    // Save data to file
    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for (Employee e : employeeMap.values()) {
                pw.println(e);
            }
        } catch (IOException e) {
            System.out.println("File write error.");
        }
    }

    // Add employee
    public void addEmployee(Employee e) throws ValidationException {
        if (employeeMap.containsKey(e.getId()))
            throw new ValidationException("Employee ID must be unique.");
        if (e.getSalary() <= 0)
            throw new ValidationException("Salary must be positive.");
        if (e.getDepartment().isEmpty())
            throw new ValidationException("Department cannot be empty.");

        employeeMap.put(e.getId(), e);
        departments.add(e.getDepartment());
        saveToFile();
        System.out.println("Employee added successfully.");
    }

    // Display employees
    public void displayEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employeeMap.values()) {
            System.out.println(e);
        }
    }

    // Search employee
    public void searchEmployee(int id) {
        Employee e = employeeMap.get(id);
        if (e != null)
            System.out.println(e);
        else
            System.out.println("Employee not found.");
    }

    // Update salary
    public void updateSalary(int id, double salary) throws ValidationException {
        if (salary <= 0)
            throw new ValidationException("Salary must be positive.");

        Employee e = employeeMap.get(id);
        if (e == null) {
            System.out.println("Employee not found.");
            return;
        }
        e.setSalary(salary);
        saveToFile();
        System.out.println("Salary updated successfully.");
    }

    // Delete employee
    public void deleteEmployee(int id) {
        if (employeeMap.remove(id) != null) {
            saveToFile();
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Display sorted employees
    public void displaySortedEmployees() {
        List<Employee> list = new ArrayList<>(employeeMap.values());
        list.sort(Comparator.comparingDouble(Employee::getSalary));
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    // Display departments
    public void displayDepartments() {
        System.out.println("Departments:");
        for (String d : departments) {
            System.out.println(d);
        }
    }
}

