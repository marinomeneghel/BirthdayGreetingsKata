package com.xpeppers;

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
        greetingService.sendGreetings(today);
    }
}
