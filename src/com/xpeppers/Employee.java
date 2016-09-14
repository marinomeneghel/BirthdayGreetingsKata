package com.xpeppers;

public class Employee {

    private String name;

    public static class Builder {
        private Employee employee;

        public Builder() {}

        public Builder withName(String name) {
            employee.name = name;
            return this;
        }
    }
}
