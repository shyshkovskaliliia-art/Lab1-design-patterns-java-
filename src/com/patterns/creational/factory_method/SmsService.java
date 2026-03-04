package com.patterns.creational.factory_method;

public class SmsService extends NotificationService {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}