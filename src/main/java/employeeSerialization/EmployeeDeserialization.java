package employeeSerialization;

import java.io.*;
import java.util.List;

public class EmployeeDeserialization {
    private static final String FILE_NAME = "employees.ser";

    // Method to deserialize employee list
    public static List<Employee> loadEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Employee data file not found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
        return null;
    }
}

