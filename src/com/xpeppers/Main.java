package com.xpeppers;

import com.xpeppers.services.BirthdayService;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        BirthdayService service = new BirthdayServiceFactory().buildWithView( () -> {

        });
        service.sendGreetings(new Date());
    }
}
