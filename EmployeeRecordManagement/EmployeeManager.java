package EmployeeRecordManagement;

import java.util.*;

//Implementation class using Map collections
public class EmployeeManager implements EmployeeOperations {

 // HashMap allows null key and null value
 private HashMap<Integer, Employee> hashMap = new HashMap<>();

 // Hashtable does not allow null
 private Hashtable<Integer, Employee> hashtable = new Hashtable<>();

 // TreeMap stores sorted data, no null key
 private TreeMap<Integer, Employee> treeMap = new TreeMap<>();

 @Override
 public void addEmployee(Employee e) {
     hashMap.put(e.getEmpId(), e);
     hashtable.put(e.getEmpId(), e);
     treeMap.put(e.getEmpId(), e);
     System.out.println("Employee added successfully.");
 }

 @Override
 public void displayEmployees() {
     if (hashMap.isEmpty()) {
         System.out.println("No employee records found.");
         return;
     }
     for (Employee e : hashMap.values()) {
         System.out.println(e);
     }
 }

 @Override
 public void searchEmployee(int empId) {
     Employee e = hashMap.get(empId);
     if (e != null)
         System.out.println("Employee Found: " + e);
     else
         System.out.println("Employee not found.");
 }

 @Override
 public void removeEmployee(int empId) {
     if (hashMap.remove(empId) != null) {
         hashtable.remove(empId);
         treeMap.remove(empId);
         System.out.println("Employee removed successfully.");
     } else {
         System.out.println("Employee not found.");
     }
 }

 // Demonstrates null key/value support
 public void demonstrateNullSupport() {
     System.out.println("\n--- Null Support Demo ---");

     hashMap.put(null, null);
     System.out.println("HashMap allows null key & value.");

     try {
         hashtable.put(null, null);
     } catch (NullPointerException e) {
         System.out.println("Hashtable does NOT allow null.");
     }

     try {
         treeMap.put(null, null);
     } catch (NullPointerException e) {
         System.out.println("TreeMap does NOT allow null key.");
     }
 }
}
