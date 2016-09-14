package com.xpeppers;

import com.xpeppers.services.GreetingService;

import java.util.Date;

class FakeEmailServiceSpy implements GreetingService {

    public static final boolean SHOULD_SUCCEED = true;
    public static final boolean SHOULD_FAIL = false;

    private int sendGreetingsCalls = 0;
    private boolean success;

    public FakeEmailServiceSpy(boolean success) {
        this.success = success;
    }

    @Override
    public void sendGreetings(Date date) {
        sendGreetingsCalls++;
    }

    public boolean isCalled(int times) {
        return sendGreetingsCalls == times;
    }
}
