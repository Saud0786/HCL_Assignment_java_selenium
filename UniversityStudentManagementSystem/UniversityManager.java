package UniversityStudentManagementSystem;
import java.util.*;


//Manager class
class UniversityManager implements UniversityOperations {

 // List implementations
 private List<Student> arrayList = new ArrayList<>();
 private Vector<Student> vector = new Vector<>();
 private Stack<Student> stack = new Stack<>();

 // Map implementations
 private HashMap<Integer, Student> hashMap = new HashMap<>();
 private Hashtable<Integer, Student> hashtable = new Hashtable<>();

 // Set for unique courses
 private Set<String> courseSet = new HashSet<>();

 @Override
 public void addStudent(Student s) {

     // Prevent duplicate entry
     if (hashMap.containsKey(s.getId())) {
         System.out.println("Student with this ID already exists.");
         return;
     }

     arrayList.add(s);
     vector.add(s);
     stack.push(s);

     hashMap.put(s.getId(), s);
     hashtable.put(s.getId(), s);

     courseSet.add(s.getCourse());

     System.out.println("Student added successfully.");
 }

 @Override
 public void displayStudents() {
     if (arrayList.isEmpty()) {
         System.out.println("No student records found.");
         return;
     }
     for (Student s : arrayList) {
         System.out.println(s);
     }
 }

 @Override
 public void removeStudent(int id) {
     Student s = hashMap.remove(id);
     if (s == null) {
         System.out.println("Student not found.");
         return;
     }
     arrayList.remove(s);
     vector.remove(s);
     stack.remove(s);
     hashtable.remove(id);
     System.out.println("Student removed successfully.");
 }

 @Override
 public void searchStudent(int id) {
     Student s = hashMap.get(id);
     if (s != null)
         System.out.println("Student Found: " + s);
     else
         System.out.println("Student not found.");
 }

 @Override
 public void sortByMarks() {
     arrayList.sort(Comparator.comparingInt(Student::getMarks).reversed());
     System.out.println("Students sorted by marks.");
     displayStudents();
 }

 // Convert HashMap to TreeMap
 public void convertToTreeMap() {
     TreeMap<Integer, Student> treeMap = new TreeMap<>(hashMap);
     System.out.println("HashMap converted to TreeMap (sorted by ID):");
     for (Student s : treeMap.values()) {
         System.out.println(s);
     }
 }

 @Override
 public void countCourseWise() {
     Map<String, Integer> countMap = new HashMap<>();
     for (Student s : arrayList) {
         countMap.put(s.getCourse(),
                 countMap.getOrDefault(s.getCourse(), 0) + 1);
     }
     for (String c : countMap.keySet()) {
         System.out.println(c + " : " + countMap.get(c));
     }
 }

 @Override
 public void displayCourses() {
     System.out.println("Available Courses:");
     for (String c : courseSet) {
         System.out.println(c);
     }
 }
}
