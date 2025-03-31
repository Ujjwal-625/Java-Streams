import java.io.*;

public class StudentDataHandler {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        // Sample student data
        Student student1 = new Student(101, "Alice", 3.8);
        Student student2 = new Student(102, "Bob", 3.5);

        // Store student data
        storeStudentData(student1);
        storeStudentData(student2);

        // Retrieve student data
        retrieveStudentData();
    }

    // Method to store student details in a binary file
    public static void storeStudentData(Student student) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
            dos.writeInt(student.rollNumber);
            dos.writeUTF(student.name);
            dos.writeDouble(student.gpa);
            System.out.println("Stored: " + student);
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    // Method to retrieve student details from the binary file
    public static void retrieveStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nRetrieving Student Data:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}

// Student class to represent student details
class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa;
    }
}
