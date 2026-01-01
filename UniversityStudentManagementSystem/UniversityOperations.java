package UniversityStudentManagementSystem;

//Interface for operations
interface UniversityOperations {
 void addStudent(Student s);
 void displayStudents();
 void removeStudent(int id);
 void searchStudent(int id);
 void sortByMarks();
 void countCourseWise();
 void displayCourses();
}