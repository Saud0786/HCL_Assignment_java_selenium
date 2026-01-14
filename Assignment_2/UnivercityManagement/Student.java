
package Assignment_2.UnivercityManagement;


//Student class
class Student {
 private int id;
 private String name;
 private String course;
 private int marks;

 public Student(int id, String name, String course, int marks) {
     this.id = id;
     this.name = name;
     this.course = course;
     this.marks = marks;
 }

 public int getId() {
     return id;
 }

 public String getCourse() {
     return course;
 }

 public int getMarks() {
     return marks;
 }

 public String toString() {
     return "ID: " + id + ", Name: " + name +
            ", Course: " + course + ", Marks: " + marks;
 }
}
