class Grade {
    private Student student;
    private double score;

    public Grade(Student student, double score) {
        this.student = student;
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGrade() {
        if (score >= 80) return "A";
        else if (score >= 70) return "B";
        else if (score >= 60) return "C";
        else if (score >= 50) return "D";
        else return "F";
    }

    public String toString() {
        return student.getName() + ": " + score + " (" + getGrade() + ")";
    }
}
