package com.xpeppers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeFactory {

    public Employee build(String line) {
        String[] employeeData = line.split(",");
        String firstName = employeeData[0];
        String lastName = employeeData[1];
        Date birthday = parseDate(employeeData[2]);
        String email = employeeData[3];
        return new Employee(firstName, lastName, birthday, email);
    }

    private Date parseDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY/MM/dd");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            return new Date();
        }
    }
}
