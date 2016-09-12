package com.xpeppers;

import java.util.List;

public class BirthdayService {

    private final Repository<List<Employee>> employeesRepository;
    private final GreetingService greetingService;

    public BirthdayService(Repository<List<Employee>> employeesRepository, GreetingService greetingService) {
        this.employeesRepository = employeesRepository;
        this.greetingService = greetingService;
    }

    public void sendGreetings() {
        List<Employee> employees = employeesRepository.load();
    }
}
