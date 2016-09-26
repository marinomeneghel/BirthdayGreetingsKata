package com.xpeppers;

import com.xpeppers.services.GreetingService;

import java.util.List;

class FakeEmailServiceSpy implements GreetingService {

    public static final boolean SHOULD_SUCCEED = true;
    public static final boolean SHOULD_FAIL = false;

    private int sendGreetingsCalls = 0;
    private boolean success;
    private List<Employee> greetedEmployees;

    public FakeEmailServiceSpy(boolean success) {
        this.success = success;
    }

    @Override
    public void sendGreetings(List<Employee> employees) {
        greetedEmployees = employees;
        sendGreetingsCalls++;
    }

    public boolean isCalled(int times) {
        return sendGreetingsCalls == times;
    }

    public boolean isCalledWithParam(List<Employee> employees) {
        System.out.print("Employees -> " + employees.toString() + " greeted Employees -> "
                + greetedEmployees.toString() + " equals -> " + (greetedEmployees.equals(employees)));
        return greetedEmployees.equals(employees);
    }
}
