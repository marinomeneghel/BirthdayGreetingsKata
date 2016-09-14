package com.xpeppers;

import com.xpeppers.services.BirthdayService;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static com.xpeppers.FakeEmailServiceSpy.*;
import static org.junit.Assert.*;

public class BirthdayServiceTest {

    private BirthdayService birthdayService;
    private FakeEmailServiceSpy emailService;
    private SpyEmployeeRepository employeesRepository;

    @Before
    public void setUp() throws Exception {
        employeesRepository = new SpyEmployeeRepository();
        emailService = new FakeEmailServiceSpy(SHOULD_SUCCEED);
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

//    @Test
//    public void testWhenSendGreetingsSucceedViewCallShowGreetingsSent() throws Exception {
//        birthdayService.sendGreetings(new Date());
//
//        assertTrue(.showGreetingsSent());
//    }

}
