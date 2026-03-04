package com.patterns.creational.factory_method;

public abstract class NotificationService {
    public abstract Notification createNotification();

    public void notifyUser(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}