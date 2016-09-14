package com.xpeppers.repositories;

import com.oracle.tools.packager.Log;
import com.xpeppers.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        // todo handle getFileScanner failure!
        while(scanner.hasNext()) {
            Employee employee = buildEmployee(scanner.next());
            employees.add(employee);
        }
        return employees;
    }

    private Employee buildEmployee(String employeeString) {
        return null;
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
