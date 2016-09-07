package com.xpeppers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BirthdayServiceTest {

    @Test
    public void testWhenSendGreetingIsCalledEmployeesRepositoryCallsGetEmployees() throws Exception {
        SpyEmployeeRepository employeeRepository = new SpyEmployeeRepository();
        GreetingService emailService = null;
        BirthdayService birthdayService = new BirthdayService(employeeRepository, emailService);
        birthdayService.sendGreetings();

        assertTrue(employeeRepository.isCalled());
    }

    private class SpyEmployeeRepository implements Repository<Employee> {
        int loadCalls = 0;

        @Override
        public void store(Employee employee) {

        }

        @Override
        public Employee load() {
            loadCalls++;
            return null;
        }

        @Override
        public void delete() {

        }

        boolean isCalled() {
            return loadCalls > 0;
        }
    }
}
