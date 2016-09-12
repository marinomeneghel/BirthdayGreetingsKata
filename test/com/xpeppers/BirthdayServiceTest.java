package com.xpeppers;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class BirthdayServiceTest {

    private BirthdayService birthdayService;
    private SpyEmailService emailService;
    private SpyEmployeeRepository employeesRepository;

    @Before
    public void setUp() throws Exception {
        employeesRepository = new SpyEmployeeRepository();
        emailService = new SpyEmailService();
        birthdayService = new BirthdayService(employeesRepository, emailService);
    }

    @Test
    public void testWhenSendGreetingIsCalledEmployeesRepositoryCallsGetEmployees() throws Exception {
        birthdayService.sendGreetings(new Date());

        assertTrue(employeesRepository.isCalled(1));
    }

    @Test
    public void testWhenSendGreetingsIsCalledServiceIsCalled() throws Exception {
        birthdayService.sendGreetings(new Date());

        assertTrue(emailService.isCalled(1));
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

    private class SpyEmailService implements GreetingService {
        private int sendGreetingsCalls = 0;

        @Override
        public void sendGreetings(Date date) {
            sendGreetingsCalls++;
        }

        public boolean isCalled(int times) {
            return sendGreetingsCalls == times;
        }
    }
}
