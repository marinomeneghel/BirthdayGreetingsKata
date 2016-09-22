package com.xpeppers.services;

import com.xpeppers.Employee;

import java.util.List;

public interface GreetingService {
    void sendGreetings(List<Employee> employees);
}
