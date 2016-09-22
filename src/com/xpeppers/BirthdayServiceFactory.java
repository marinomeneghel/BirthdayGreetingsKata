package com.xpeppers;

import com.xpeppers.repositories.FlatFileEmployeesRepository;
import com.xpeppers.repositories.Repository;
import com.xpeppers.services.BirthdayService;
import com.xpeppers.services.EmailGreetingService;
import com.xpeppers.services.GreetingService;

import java.util.List;

public class BirthdayServiceFactory {

    public BirthdayService build() {
        GreetingService greetingsService = new EmailGreetingService();
        Repository<List<Employee>> employeesRepository = new FlatFileEmployeesRepository();
        return new BirthdayService(employeesRepository, greetingsService);
    }
}
