package com.xpeppers;

import com.xpeppers.repositories.FlatFileEmployeesRepository;
import com.xpeppers.repositories.Repository;
import com.xpeppers.services.BirthdayService;
import com.xpeppers.services.GreetingService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GreetingService greetingsService = null;
        Repository<List<Employee>> employeesRepository = new FlatFileEmployeesRepository();
        employeesRepository.load();
//        BirthdayService service = new BirthdayService(employeesRepository, greetingsService);
    }
}
