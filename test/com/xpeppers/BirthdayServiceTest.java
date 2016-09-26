package com.xpeppers;

import com.xpeppers.repositories.FlatFileEmployeesRepository;
import com.xpeppers.repositories.Repository;
import com.xpeppers.services.BirthdayService;
import com.xpeppers.services.GreetingService;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Test
    public void testWhenServiceIsCalledWithDateOneJanuaryTwoThousandSendGreetingsServiceIsCalledWithEmptyList() throws Exception {
        Date date = new SimpleDateFormat("YYYY/MM/dd").parse("2000/01/01");
        FakeEmailServiceSpy fakeEmailGreetingService = new FakeEmailServiceSpy(true);
        Repository<List<Employee>> employeesRepository = new FlatFileEmployeesRepository();
        birthdayService = new BirthdayService(employeesRepository, fakeEmailGreetingService);
        birthdayService.sendGreetings(date);

        assertTrue(fakeEmailGreetingService.isCalledWithParam(new ArrayList()));
    }

    //    @Test
//    public void testWhenSendGreetingsSucceedViewCallShowGreetingsSent() throws Exception {
//        birthdayService.sendGreetings(new Date());
//
//        assertTrue(.showGreetingsSent());
//    }

}
