package definingclasses.companyroster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Department> departmentList = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            Employee currentEmployee = getCurrentEmployee(inputArgs);

            addEmployeeToDepartment(departmentList, currentEmployee);
        }
        System.out.println(getDepartmentWithHighestSalary(departmentList));
    }

    private static String getDepartmentWithHighestSalary(List<Department> departmentList) {
        double bestSalary = Integer.MIN_VALUE;
        Department bestDep = null;

        for (Department department : departmentList) {
            double currDepartmentAvgSalary = department.getAverageSalary();
            if (currDepartmentAvgSalary > bestSalary) {
                bestSalary = currDepartmentAvgSalary;
                bestDep = department;
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Highest Average Salary: ").append(bestDep.getName()).append(System.lineSeparator());

        bestDep
                .getEmployees()
                .stream().sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(employee -> builder.append(String.format("%s %.2f %s %d%n",
                        employee.getName(),
                        employee.getSalary(),
                        employee.getEmail(),
                        employee.getAge())));

        return builder.toString();
    }

    private static void addEmployeeToDepartment(List<Department> departmentList, Employee currentEmployee) {
        for (Department department : departmentList) {
            if (department.getName().equals(currentEmployee.getDepartment())) {
                department.addEmployee(currentEmployee);
                return;
            }
        }
        departmentList.add(new Department(currentEmployee.getDepartment()));
        departmentList.get(departmentList.size() - 1).addEmployee(currentEmployee);
    }

    private static Employee getCurrentEmployee(String[] inputArgs) {
        String name = inputArgs[0];
        double salary = Double.parseDouble(inputArgs[1]);
        String position = inputArgs[2];
        String department = inputArgs[3];

        Employee currentEmployee;

        if (inputArgs.length == 5) {
            String lastArgument = inputArgs[4];
            if (inputArgs[4].contains("@")) {
                currentEmployee = new Employee(name, salary, position, department, lastArgument);
            } else {
                currentEmployee = new Employee(name, salary, position, department, Integer.parseInt(lastArgument));
            }
        } else if (inputArgs.length == 6) {
            String email = inputArgs[4];
            int age = Integer.parseInt(inputArgs[5]);
            currentEmployee = new Employee(name, salary, position, department, email, age);
        } else {
            currentEmployee = new Employee(name, salary, position, department);
        }
        return currentEmployee;
    }
}