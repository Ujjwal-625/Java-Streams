package employeeSerialization;

import java.io.*;
import java.util.List;

public class EmployeeSerializer {
    private static final String FILE_NAME = "employees.ser";

    // Method to serialize employee list
    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees have been serialized successfully!");
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }
}
