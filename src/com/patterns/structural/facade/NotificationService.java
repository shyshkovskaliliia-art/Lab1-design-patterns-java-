package com.patterns.structural.facade;

public class NotificationService {
    public void sendEmail(String email, String subject, String body) {
        System.out.printf("  [Email] → %s%n", email);
        System.out.printf("  [Email] Тема: %s%n", subject);
        System.out.printf("  [Email] %s%n", body);
    }

    public void sendSms(String phone, String message) {
        System.out.printf("  [SMS] → %s: %s%n", phone, message);
    }
}
