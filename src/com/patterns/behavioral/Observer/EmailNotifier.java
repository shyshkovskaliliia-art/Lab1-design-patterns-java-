package com.patterns.behavioral.Observer;

public class EmailNotifier implements Observer {
    private String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void update(String orderStatus) {
        System.out.println("Email на " + email + ": Ваше замовлення тепер має статус: " + orderStatus);
    }
}
