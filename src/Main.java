import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManager gradeManager = new GradeManager();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add course and grades");
            System.out.println("2. Show all grades");
            System.out.println("3. Save grades to file");
            System.out.println("4. Load grades from file");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter course title: ");
                    String courseTitle = scanner.nextLine();
                    Course course = new Course(courseCode, courseTitle);

                    System.out.print("Enter number of students: ");
                    int numStudents = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < numStudents; i++) {
                        System.out.println("Student " + (i + 1) + " Info:");
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        Student student = new Student(id, name);
                        System.out.print("Enter grade for " + name + ": ");
                        double score = Double.parseDouble(scanner.nextLine());
                        gradeManager.addGrade(new Grade(student, course, score));
                    }
                    break;
                case "2":
                    gradeManager.printAllGrades();
                    break;
                case "3":
                    System.out.print("Enter filename to save data (e.g., grades.csv): ");
                    String saveFilename = scanner.nextLine();
                    gradeManager.saveToFile(saveFilename);
                    break;
                case "4":
                    System.out.print("Enter filename to load data (e.g., grades.csv): ");
                    String loadFilename = scanner.nextLine();
                    gradeManager.loadFromFile(loadFilename);
                    break;
                case "5":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
