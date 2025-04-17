import java.io.*;
import java.util.*;

class GradeManager {
    private List<Grade> grades = new ArrayList<>();

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public Grade getGrade(String studentID) {
        for (Grade g : grades) {
            if (g.getStudent().getID().equals(studentID)) {
                return g;
            }
        }
        return null;
    }

    public void updateScore(String studentID, double score) {
        Grade g = getGrade(studentID);
        if (g != null) {
            g.setScore(score);
        }
    }

    public void printAllGrades() {
        for (Grade g : grades) {
            System.out.println(g);
        }
    }

    public boolean isEmpty(){
        return grades.isEmpty();
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Grade g : grades) {
                writer.println(g.toString()); // use the same format as printAllGrades
            }
            System.out.println("Grades saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving grades: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        grades.clear();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            // Example: "ID: 1, Name: a, Score: 50.0, Grade: D"
            String[] parts = line.split(",");

            if (parts.length >= 3) {
                String studentID = parts[0].split(":")[1].trim();
                String studentName = parts[1].split(":")[1].trim();
                String scoreStr = parts[2].split(":")[1].trim();

                try {
                    double score = Double.parseDouble(scoreStr);
                    Student student = new Student(studentID, studentName);
                    grades.add(new Grade(student, score));
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