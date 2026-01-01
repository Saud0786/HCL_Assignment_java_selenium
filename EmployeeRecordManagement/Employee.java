package EmployeeRecordManagement;

//Employee data class
public class Employee {

 private int empId;
 private String name;
 private String email;

 public Employee(int empId, String name, String email) {
     this.empId = empId;
     this.name = name;
     this.email = email;
 }

 public int getEmpId() {
     return empId;
 }

 public String toString() {
     return "ID: " + empId + ", Name: " + name + ", Email: " + email;
 }
}
