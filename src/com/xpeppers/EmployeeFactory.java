package com.xpeppers;

public class EmployeeFactory {

    public Employee build(String line) {
        String[] employeeData = line.split(",");
        String firstName = employeeData[0];
        String lastName = employeeData[1];
        String birthday = employeeData[2];
        String email    = employeeData[3];
        return new Employee(firstName, lastName, birthday, email);
    }
}
