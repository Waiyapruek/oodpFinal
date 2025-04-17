import java.io.*;
import java.util.*;

class GradeManager {
    private List<Grade> grades = new ArrayList<>();

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public Grade getGrade(String studentID, String courseCode) {
        for (Grade g : grades) {
            if (g.getStudent().getID().equals(studentID) && g.getCourse().getCode().equals(courseCode)) {
                return g;
            }
        }
        return null;
    }

    public void updateScore(String studentID, String courseCode, double score) {
        Grade g = getGrade(studentID, courseCode);
        if (g != null) {
            g.setScore(score);
        }
    }

    public void removeGrade(String studentID, String courseCode) {
        grades.removeIf(g -> g.getStudent().getID().equals(studentID) && g.getCourse().getCode().equals(courseCode));
    }

    public void printAllGrades() {
        for (Grade g : grades) {
            System.out.println(g);
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Grade g : grades) {
                writer.println(g.getStudent().getID() + "," + g.getStudent().getName() + "," + g.getCourse().getCode() + "," + g.getCourse().getTitle() + "," + g.getScore() + "," + g.getLetterGrade());
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
                if (parts.length >= 5) {
                    String studentID = parts[0];
                    String studentName = parts[1];
                    String courseCode = parts[2];
                    String courseTitle = parts[3];
                    double score = Double.parseDouble(parts[4]);
                    Student student = new Student(studentID, studentName);
                    Course course = new Course(courseCode, courseTitle);
                    grades.add(new Grade(student, course, score));
                }
            }
            System.out.println("Grades loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading grades: " + e.getMessage());
        }
    }
}