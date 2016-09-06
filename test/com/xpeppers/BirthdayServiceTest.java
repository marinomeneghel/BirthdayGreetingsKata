package com.xpeppers;

import org.junit.Test;

public class BirthdayServiceTest {

    @Test
    public void testWhenSendGreetingIsCalledEmployeesRepositoryCallsGetEmployees() throws Exception {
        Repository<Employee> employeeRepository = null;
        GreetingService emailService = null;
        BirthdayService birthdayService = new BirthdayService(employeeRepository, emailService);
    }
}
