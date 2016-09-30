package com.xpeppers;

import java.util.List;

public class SpyMainView implements MainView {

    private boolean called = false;

    @Override
    public void showGreetingsSent() {
        called = true;
    }

    public boolean showGreetingsSentCalled() {
        return called;
    }
}
