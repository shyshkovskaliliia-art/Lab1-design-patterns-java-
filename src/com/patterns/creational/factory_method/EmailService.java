package com.patterns.creational.factory_method;

public class EmailService extends NotificationService {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}