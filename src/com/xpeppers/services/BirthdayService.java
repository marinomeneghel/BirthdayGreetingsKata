package com.xpeppers.services;

import com.xpeppers.Employee;
import com.xpeppers.repositories.Repository;

import java.util.Date;
import java.util.List;

public class BirthdayService {

    private final Repository<List<Employee>> employeesRepository;
    private final GreetingService greetingService;

    public BirthdayService(Repository<List<Employee>> employeesRepository, GreetingService greetingService) {
        this.employeesRepository = employeesRepository;
        this.greetingService = greetingService;
    }

    public void sendGreetings(Date today) {
        List<Employee> employees = employeesRepository.load();
        // todo filter employees depending on birthday
        greetingService.sendGreetings(employees);
    }
}
