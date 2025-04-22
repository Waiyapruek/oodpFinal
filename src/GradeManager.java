import java.io.*;
import java.util.*;

// Manages a list of grades (adding, updating, printing, saving, loading)
class GradeManager {
    private List<Grade> grades = new ArrayList<>(); // Stores all grades in a list

    // Add a new grade to the list
    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    // Get a student's grade using their ID
    public Grade getGrade(String studentID) {
        for (Grade g : grades) {
            if (g.getStudent().getID().equals(studentID)) {
                return g;
            }
        }
        return null; // If student ID not found
    }

    // Update the score for a student
    public void updateScore(String studentID, double score) {
        Grade g = getGrade(studentID);
        if (g != null) {
            g.setScore(score); // Update the score if student is found
        }
    }

    // Print all grades to the console
    public void printAllGrades() {
        for (Grade g : grades) {
            System.out.println(g); // Calls Grade.toString()
        }
    }

    // Check if the grade list is empty
    public boolean isEmpty(){
        return grades.isEmpty();
    }

    // Save all grades to a text file
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Grade g : grades) {
                writer.println(g.toString()); // Save each grade in readable format
            }
            System.out.println("Grades saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving grades: " + e.getMessage());
        }
    }

    // Load grades from a file and rebuild the grade list
    public void loadFromFile(String filename) {
        grades.clear(); // Clear existing data before loading new data
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Expected format: "ID: 1, Name: John, Score: 75.0, Grade: B"
                String[] parts = line.split(",");

                if (parts.length >= 3) {
                    String studentID = parts[0].split(":")[1].trim();
                    String studentName = parts[1].split(":")[1].trim();
                    String scoreStr = parts[2].split(":")[1].trim();

                    try {
                        double score = Double.parseDouble(scoreStr);
                        Student student = new Student(studentID, studentName);
                        grades.add(new Grade(student, score)); // Add new grade to list
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid score format for line: " + line);
                    }
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
            System.out.println("Grades loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading grades: " + e.getMessage());
        }
    }
}
