import java.util.Map;
import java.util.TreeMap;

public class StudentRecordManager {
    private Map<Integer, Student> studentRecords;

    public StudentRecordManager() {
        studentRecords = new TreeMap<>();
    }

    public void addStudent(int id, String name, double gpa) {
        if (studentRecords.containsKey(id)) {
            System.out.println("Student ID already exists. Cannot add.");
        } else {
            studentRecords.put(id, new Student(name, gpa));
            System.out.println("Student added: " + name);
        }
    }

    public void deleteStudent(int id) {
        if (studentRecords.containsKey(id)) {
            studentRecords.remove(id);
            System.out.println("Student with ID " + id + " removed.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    public void updateStudentGpa(int id, double newGpa) {
        Student student = studentRecords.get(id);
        if (student != null) {
            student.setGpa(newGpa);
            System.out.println("Updated GPA for student ID " + id);
        } else {
            System.out.println("Student ID not found.");
        }
    }

    public void displayAllRecords() {
        if (studentRecords.isEmpty()) {
            System.out.println("No records to display.");
            return;
        }
        for (Map.Entry<Integer, Student> entry : studentRecords.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", " + entry.getValue());
        }
    }

    public void findStudentsWithHigherGpa(double threshold) {
        boolean found = false;
        for (Map.Entry<Integer, Student> entry : studentRecords.entrySet()) {
            if (entry.getValue().getGpa() > threshold) {
                System.out.println("ID: " + entry.getKey() + ", " + entry.getValue());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with GPA higher than " + threshold);
        }
    }

    public static void main(String[] args) {
        StudentRecordManager manager = new StudentRecordManager();

        manager.addStudent(101, "Alice", 3.8);
        manager.addStudent(102, "Bob", 3.2);
        manager.addStudent(103, "Charlie", 3.5);
        manager.addStudent(104, "David", 3.9);
        manager.addStudent(105, "Eva", 3.0);

        System.out.println("\nDisplaying all records:");
        manager.displayAllRecords();

        manager.updateStudentGpa(103, 3.7);

        System.out.println("\nDisplaying all records after GPA update:");
        manager.displayAllRecords();

        manager.deleteStudent(102);

        System.out.println("\nDisplaying all records after deletion:");
        manager.displayAllRecords();

        System.out.println("\nStudents with GPA higher than 3.5:");
        manager.findStudentsWithHigherGpa(3.5);
    }
}
