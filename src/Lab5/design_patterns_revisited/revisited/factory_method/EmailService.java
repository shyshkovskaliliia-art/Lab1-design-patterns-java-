package Lab5.design_patterns_revisited.revisited.factory_method;

public class EmailService implements NotificationService {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
