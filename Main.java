import java.util.Scanner;

public class Main {

    private static StudentManagementSystem sms = new StudentManagementSystem();//This will send all the new student info over to StudentManagementSystem.java

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add a new student");
            System.out.println("2. Delete a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Sort students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    deleteStudent(scanner);
                    break;
                case 3:
                    searchStudent(scanner);
                    break;
                case 4:
                    sms.displayStudents();
                    break;
                case 5:
                    sortStudents(scanner);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 5.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();

        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // It goes to the next line anyways

        Student student = new Student(id, name, age, grade);
        sms.addStudent(student);//send to sms
        System.out.println("Student added successfully.");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();
        boolean result = sms.deleteStudent(id);//send to sms to delete

        if (result) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter student ID or name to search: ");
        String identifier = scanner.nextLine();
        sms.searchStudent(identifier);//search call to sms
    }

    private static void sortStudents(Scanner scanner) {
        System.out.println("Choose sort criteria:");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Age");
        System.out.println("4. Grade");
        int sortChoice = scanner.nextInt();
        scanner.nextLine(); 

        sms.sortStudents(sortChoice);
        System.out.println("Students sorted successfully.");//sort callout to sms
    }
}
