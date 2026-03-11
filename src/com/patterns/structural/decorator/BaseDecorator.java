package com.patterns.structural.decorator;

public abstract class BaseDecorator implements Notifier {
    private final Notifier wrappee;

    public BaseDecorator(Notifier notifier) {
        this.wrappee = notifier;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}
