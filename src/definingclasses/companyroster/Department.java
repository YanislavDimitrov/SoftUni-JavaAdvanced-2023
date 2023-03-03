package definingclasses.companyroster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public double getAverageSalary() {
        double totalSalary = 0;

        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / this.employees.size();
    }
}
