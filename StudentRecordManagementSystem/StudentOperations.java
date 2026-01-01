package StudentRecordManagementSystem;

//Interface defining operations
interface StudentOperations {
 void addStudent(Student s);
 void displayStudents();
 void removeStudent(int rollNo);
 void searchStudent(int rollNo);
}
