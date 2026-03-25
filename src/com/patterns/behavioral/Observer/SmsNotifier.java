package com.patterns.behavioral.Observer;

public class SmsNotifier implements Observer {
    private String phone;

    public SmsNotifier(String phone) {
        this.phone = phone;
    }

    @Override
    public void update(String orderStatus) {
        System.out.println("SMS на " + phone + ": Новий статус замовлення: " + orderStatus);
    }
}
