import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
        System.out.println("Student added successfully: " + student.getName());
    }

    public boolean deleteStudent(String id) {
        for (Student student : this.students) {
            if (student.getId().equals(id)) {
                this.students.remove(student);
                System.out.println("Student deleted successfully: " + student.getName());
                return true;
            }
        }
        System.out.println("Student not found with ID: " + id);
        return false;
    }

    public void searchStudent(String identifier) {
        for (Student student : this.students) {
            if (student.getId().equals(identifier) || student.getName().equalsIgnoreCase(identifier)) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("No student found with ID or name: " + identifier);
    }


    //displaying students by their name and grade
    public void displayStudents() {
        if (this.students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            this.students.forEach(student -> System.out.println("Name: " + student.getName() + ", Grade: " + student.getGrade()));
        }
    }
    

    // This method calls out the quicksort function in sortAlgo.java
    //This step might be  redundant and could have been done in Main.java but it makes the code cleaner 
    public void sortStudents(int sortChoice) {
    //initializing this variable outsside the switches so it is always availiable.
        Comparator<Student> comparator = null;
    
        switch (sortChoice) {
            case 1: // Sort by ID
                comparator = Comparator.comparing(Student::getId);
                break;
            case 2: // Sort by Name
                comparator = Comparator.comparing(Student::getName);
                break;
            case 3: // Sort by Age
                comparator = Comparator.comparingInt(Student::getAge);
                break;
            case 4: // Sort by Grade
                comparator = Comparator.comparingDouble(Student::getGrade);
                break;
            default:
                System.out.println("Invalid sorting criteria selected.");
                return;
        }
    
        // SortAlgorithms.quickSort(this.students, comparator);
       students = SortAlgorithms.quickSort(this.students, comparator);
       this.students.forEach(student -> System.out.println("Name: " + student.getName() + ", Grade: " + student.getGrade() + ", Age: " + student.getAge() + ", Id: " + student.getId()));
        System.out.println("Students sorted successfully.");
    }
    
}
