import java.util.*;

public class ProgramStart {
    private static double score; // Used to store input score

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        GradeManager gradeManager = new GradeManager(); // Grade manager instance

        while (true) {
            // Display menu options
            System.out.println("\nMenu:");
            System.out.println("1. Add students' score");
            System.out.println("2. Show all grades");
            System.out.println("3. Save grades to file");
            System.out.println("4. Load grades from file");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine(); // Read user choice

            switch (choice) {
                case "1":
                    // Input new student information
                    System.out.println("==== Student Info ====");
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    Student student = new Student(id, name);

                    // Input  score
                    while (true) {
                        System.out.print("Enter score for " + name + ": ");
                        score = Double.parseDouble(scanner.nextLine());
                        if (score < 0 || score > 100) {
                            System.out.println("Invalid score. Please enter a score between 0 and 100.");
                        } else {
                            break;
                        }
                    }

                    // Add the student's grade to the system
                    gradeManager.addGrade(new Grade(student, score));
                    break;

                case "2":
                    // Display all student grades
                    if (gradeManager.isEmpty()) {
                        System.out.println("\nSorry, We don't have a score yet.");
                    } else {
                        gradeManager.printAllGrades();
                    }
                    break;

                case "3":
                    // Save all grade records to a file
                    System.out.print("Enter filename to save data (e.g., grades.csv): ");
                    String saveFilename = scanner.nextLine();
                    gradeManager.saveToFile(saveFilename);
                    break;

                case "4":
                    // Load grade records from a file
                    System.out.print("Enter filename to load data (e.g., grades.csv): ");
                    String loadFilename = scanner.nextLine();
                    gradeManager.loadFromFile(loadFilename);
                    break;

                case "5":
                    // Exit the program
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    // Handle invalid input
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
