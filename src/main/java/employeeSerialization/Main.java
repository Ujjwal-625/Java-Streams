package employeeSerialization;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        // Get employee details from user
        System.out.print("Enter the number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Department: ");
            String department = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            employees.add(new Employee(id, name, department, salary));
        }

        // Serialize employees
        EmployeeSerializer.saveEmployees(employees);

        // Deserialize and display employees
        List<Employee> loadedEmployees = EmployeeDeserialization.loadEmployees();
        if (loadedEmployees != null) {
            System.out.println("\nDeserialized Employee Data:");
            for (Employee emp : loadedEmployees) {
                System.out.println(emp);
            }
        }

        scanner.close();
    }
}

