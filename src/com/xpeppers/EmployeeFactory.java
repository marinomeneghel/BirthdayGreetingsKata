package com.xpeppers;

import java.text.DateFormat;
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date = formatter.parse(dateString);
            System.out.print("date string -> " + dateString + " ");
            System.out.print("date -> " + date + " \n");
            return date;
        } catch (ParseException e) {
            System.out.print("Exception parsing date " + e.getMessage());
            return new Date();
        }
    }
}
