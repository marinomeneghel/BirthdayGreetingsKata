package com.xpeppers.services;

import com.xpeppers.Employee;
import com.xpeppers.MainView;
import com.xpeppers.repositories.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayService implements GreetingCallback {

    private final Repository<List<Employee>> employeesRepository;
    private final GreetingService greetingService;
    private MainView view;

    public BirthdayService(Repository<List<Employee>> employeesRepository,
                           GreetingService greetingService,
                           MainView view) {
        this.employeesRepository = employeesRepository;
        this.greetingService = greetingService;
        this.view = view;
    }

    public void sendGreetings(Date today) {
        List<Employee> employees = getEmployeesForBirthday(employeesRepository.load(), today);
        greetingService.sendGreetings(employees, this);
    }

    private List<Employee> getEmployeesForBirthday(List<Employee> employees, Date date) {
        return employees.stream()
                .filter(employee -> employee.birthdayEquals(date))
                .collect(Collectors.toList());
    }

    @Override
    public void sendGreetingSuccess() {
        view.showGreetingsSent();
    }

    @Override
    public void sendGreetingFailed() {

    }
}
