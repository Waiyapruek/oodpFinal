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
                writer.println(g.getStudent().getID() + "," + g.getStudent().getName() + "," + "," + g.getScore() + "," + g.getGrade());
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
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String studentID = parts[0];
                    String studentName = parts[1];
                    double score = Double.parseDouble(parts[2]);
                    Student student = new Student(studentID, studentName);
                    grades.add(new Grade(student, score));
                }
            }
            System.out.println("Grades loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading grades: " + e.getMessage());
        }
    }
}