package EmployeeRecordManagement;

//Interface defining employee operations
public interface EmployeeOperations {
 void addEmployee(Employee e);
 void displayEmployees();
 void searchEmployee(int empId);
 void removeEmployee(int empId);
}