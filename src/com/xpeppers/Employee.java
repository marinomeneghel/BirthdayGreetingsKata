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

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public boolean equals(Object employee) {
        if (!(employee instanceof Employee)) {
            throw new ClassCastException("The given object have to be an instance of Employee");
        }
        return ((Employee) employee).email.equals(email) &&
                ((Employee) employee).firstName.equals(firstName) &&
                ((Employee) employee).lastName.equals(lastName) &&
                ((Employee) employee).birthday.equals(birthday);
    }
}
