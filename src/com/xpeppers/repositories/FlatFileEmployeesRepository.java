package com.xpeppers.repositories;

import com.xpeppers.Employee;
import com.xpeppers.EmployeeFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlatFileEmployeesRepository implements Repository<List<Employee>> {

    @Override
    public void store(List<Employee> employees) {

    }

    @Override
    public List<Employee> load() {
        List<Employee> employees = new ArrayList<>();
        Scanner scanner = getFileScanner();
        scanner.useDelimiter("\n");
        // todo handle getFileScanner failure!
        while(scanner.hasNext()) {
            String employeeStr = scanner.next();
            System.out.print(" read line ----> " + employeeStr);
            Employee employee = buildEmployee(employeeStr);
            employees.add(employee);
        }
        return employees;
    }

    private Employee buildEmployee(String employeeString) {
        EmployeeFactory factory = new EmployeeFactory();
        return factory.build(employeeString);
    }

    private Scanner getFileScanner() {
        try {
            return new Scanner(new FileReader("./assets/employees"));
        } catch (FileNotFoundException e) {
            System.out.print("Exception reading file " + e);
        }
        return null;
    }

    @Override
    public void delete() {

    }
}
