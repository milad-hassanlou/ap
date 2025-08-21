package ap.exercises.finalproject;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private final List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public Employee authenticateEmployee(String username, String password) {
        return employees.stream()
                .filter(e -> e.getUsername().equals(username) && e.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public void employeePasswordChanging(Employee employee, String password) {
        employees.stream()
                .filter(e->e==employee)
                .forEach(e->e.setPassword(password));
        System.out.println("Password Successfully Changed.");
    }
}
