package ap.exercises.ex4;

public class Main_EX4_E3_12 {  //Employee
    private String employeeName;
    private int currentSalary;

    public Main_EX4_E3_12(String employeeName, int currentSalary) {
        this.employeeName = employeeName;
        this.currentSalary = currentSalary;
    }

    public String getName() {
        return employeeName;
    }

    public int getSalary() {
        return currentSalary;
    }

    public void raiseSalary(double byPercent) {
        currentSalary += currentSalary * (byPercent / 100);
    }
}


class TestingMain { //The class Should be Public to be run.(It's -_GitHub_- Exception Here!)
    public static void main(String[] args) {
        Main_EX4_E3_12 employee1 = new Main_EX4_E3_12("Milad", 500);
        employee1.raiseSalary(25);
        System.out.println("Employee Name: " + employee1.getName());
        System.out.println("Employee Salary: " + employee1.getSalary());
    }
}
