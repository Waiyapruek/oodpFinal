// Represents a student and inherits from Person
class Student extends Person {
    private String id;   // Student's ID (e.g., "673xxx")
    private String name; // Student's name (e.g., "Liz")

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Return student's ID
    public String getID() {
        return id;
    }

    // Return student's name
    public String getName() {
        return name;
    }

    // Display student info as "673xx: Liz"
    public String toString() {
        return id + ": " + name;
    }
}
