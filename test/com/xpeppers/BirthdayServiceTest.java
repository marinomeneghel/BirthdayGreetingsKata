package com.xpeppers;

import com.xpeppers.repositories.FlatFileEmployeesRepository;
import com.xpeppers.repositories.Repository;
import com.xpeppers.services.BirthdayService;
import org.junit.Before;
import org.junit.Test;

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
    private SpyMainView view;

    @Before
    public void setUp() throws Exception {
        employeesRepository = new SpyEmployeeRepository();
        view = new SpyMainView();
        emailService = new FakeEmailServiceSpy(SHOULD_SUCCEED);
        birthdayService = new BirthdayService(employeesRepository, emailService, view);
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
    public void testWhenServiceIsCalledWithNoEmployeesBirthdaySendGreetingsServiceIsCalledWithEmptyList() throws Exception {
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2000/01/01");
        FakeEmailServiceSpy fakeEmailGreetingService = new FakeEmailServiceSpy(SHOULD_SUCCEED);
        Repository<List<Employee>> employeesRepository = new FlatFileEmployeesRepository();
        birthdayService = new BirthdayService(employeesRepository, fakeEmailGreetingService, view);
        birthdayService.sendGreetings(date);

        assertTrue(fakeEmailGreetingService.isCalledWithParam(new ArrayList()));
    }

    @Test
    public void testWhenServiceIsCalledWithOneEmployeeBirthdaySendGreetingsServiceIsCalledWithOneEmployee() throws Exception {
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse("1978/09/12");
        FakeEmailServiceSpy fakeEmailGreetingService = new FakeEmailServiceSpy(SHOULD_SUCCEED);
        Repository<List<Employee>> employeesRepository = new FlatFileEmployeesRepository();
        birthdayService = new BirthdayService(employeesRepository, fakeEmailGreetingService, view);
        birthdayService.sendGreetings(date);

        List<Employee> greetedEmployees = new ArrayList<>();
        Employee employee = new EmployeeFactory().build("Boe, Ostrich, 1978/09/12, mary.ann@foobar.com");
        greetedEmployees.add(employee);
        assertTrue(fakeEmailGreetingService.isCalledWithParam(greetedEmployees));
    }

    @Test
    public void testWhenSendGreetingsSucceedViewCallShowGreetingsSent() throws Exception {
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse("1989/05/29");
        FakeEmailServiceSpy fakeEmailGreetingService = new FakeEmailServiceSpy(SHOULD_SUCCEED);
        Repository<List<Employee>> employeesRepository = new FlatFileEmployeesRepository();
        birthdayService = new BirthdayService(employeesRepository, fakeEmailGreetingService, view);
        birthdayService.sendGreetings(date);

        assertTrue(view.showGreetingsSentCalled());
    }

}
