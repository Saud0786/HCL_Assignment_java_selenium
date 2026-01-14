package Assignment_2.StudentRecordManagement;
import java.util.*;
import java.util.regex.Pattern;

//Implementation class
class StudentManager implements StudentOperations {

 // Using List reference with ArrayList
 private List<Student> studentList = new ArrayList<>();

 // Vector example (legacy collection)
 private Vector<Student> backupList = new Vector<>();

 @Override
 public void addStudent(Student s) {
     studentList.add(s);
     backupList.add(s); // storing in vector also
     System.out.println("Student added successfully.");
 }

 @Override
 public void displayStudents() {
     if (studentList.isEmpty()) {
         System.out.println("No student records found.");
         return;
     }
     for (Student s : studentList) {
         System.out.println(s);
     }
 }

 @Override
 public void removeStudent(int rollNo) {
     Iterator<Student> it = studentList.iterator();
     boolean found = false;

     while (it.hasNext()) {
         Student s = it.next();
         if (s.getRollNo() == rollNo) {
             it.remove();
             backupList.remove(s);
             found = true;
             System.out.println("Student removed successfully.");
             break;
         }
     }

     if (!found) {
         System.out.println("Student not found.");
     }
 }

 @Override
 public void searchStudent(int rollNo) {
     for (Student s : studentList) {
         if (s.getRollNo() == rollNo) {
             System.out.println("Student Found: " + s);
             return;
         }
     }
     System.out.println("Student not found.");
 }
}