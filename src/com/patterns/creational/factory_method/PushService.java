package com.patterns.creational.factory_method;

public class PushService extends NotificationService {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}