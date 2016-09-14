package com.xpeppers;

import com.xpeppers.services.GreetingService;

import java.util.Date;

class SpyEmailService implements GreetingService {
    private int sendGreetingsCalls = 0;

    @Override
    public void sendGreetings(Date date) {
        sendGreetingsCalls++;
    }

    public boolean isCalled(int times) {
        return sendGreetingsCalls == times;
    }
}
