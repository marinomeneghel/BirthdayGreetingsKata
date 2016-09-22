package com.xpeppers.services;

import com.xpeppers.Employee;
import com.xpeppers.repositories.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayService {

    private final Repository<List<Employee>> employeesRepository;
    private final GreetingService greetingService;

    public BirthdayService(Repository<List<Employee>> employeesRepository, GreetingService greetingService) {
        this.employeesRepository = employeesRepository;
        this.greetingService = greetingService;
    }

    public void sendGreetings(Date today) {
        List<Employee> employees = getEmployeesForBirthday(employeesRepository.load(), today);
        greetingService.sendGreetings(employees);
    }

    private List<Employee> getEmployeesForBirthday(List<Employee> employees, Date date) {
        return employees.stream()
                .filter(employee -> employee.birthdayEquals(date))
                .collect(Collectors.toList());
    }
}
