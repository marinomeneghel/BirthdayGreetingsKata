package com.xpeppers;

import java.util.Date;

public class Employee {

    private String firstName;
    private String lastName;
    private Date birthday;
    private String email;

    public Employee(String firstName, String lastName, Date birthday, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
    }

    public boolean birthdayEquals(Date date) {
        return birthday.equals(date);
    }
}
