package com.xpeppers;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BirthdayServiceTest {

    @Test
    public void testWhenSendGreetingIsCalledEmployeesRepositoryCallsGetEmployees() throws Exception {
        SpyEmployeeRepository employeesRepository = new SpyEmployeeRepository();
        GreetingService emailService = null;
        BirthdayService birthdayService = new BirthdayService(employeesRepository, emailService);
        birthdayService.sendGreetings();

        assertTrue(employeesRepository.isCalled(1));
    }

    private class SpyEmployeeRepository implements Repository<List<Employee>> {
        int loadCalls = 0;

        @Override
        public void store(List<Employee> employees) {

        }

        @Override
        public List<Employee> load() {
            loadCalls++;
            return null;
        }

        @Override
        public void delete() {

        }

        boolean isCalled(int times) {
            return loadCalls == times;
        }
    }
}
