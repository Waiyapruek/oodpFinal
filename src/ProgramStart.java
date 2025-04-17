import java.util.*;

public class ProgramStart {
    private static double score;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManager gradeManager = new GradeManager();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add students' score");
            System.out.println("2. Show all grades");
            System.out.println("3. Save grades to file");
            System.out.println("4. Load grades from file");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("==== Student Info ====");
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    Student student = new Student(id, name);
                    while ( true ){
                        System.out.print("Enter score for " + name + ": ");
                        score = Double.parseDouble(scanner.nextLine());
                        if (score < 0 || score > 100) {
                        System.out.println("Invalid score. Please enter a score between 0 and 100.");
                        } else {
                            break;
                    }
                }
                gradeManager.addGrade(new Grade(student, score));
                break;
                case "2":
                if (gradeManager.isEmpty()){
                    System.out.println("\nSorry, We don't have a score yet." );
                }else { gradeManager.printAllGrades();}
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
