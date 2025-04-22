class Grade {
    private Student student; // The student associated with this grade
    private double score;    // The student's numeric score (e.g., 85.5)

    // Constructor: create a grade record for a student with a given score
    public Grade(Student student, double score) {
        this.student = student;
        this.score = score;
    }

    // Returns the student object
    public Student getStudent() {
        return student;
    }

    // Returns the numeric score
    public double getScore() {
        return score;
    }

    // Allows the score to be updated
    public void setScore(double score) {
        this.score = score;
    }

    // Converts numeric score to letter grade
    public String getGrade() {
        if (score >= 80) return "A";
        else if (score >= 70) return "B";
        else if (score >= 60) return "C";
        else if (score >= 50) return "D";
        else return "F";
    }

    // Returns all grade details as a formatted string
    public String toString() {
        return "ID: " + student.getID() + ", Name: " + student.getName() +
               ", Score: " + score + ", Grade: " + getGrade();
    }
}
