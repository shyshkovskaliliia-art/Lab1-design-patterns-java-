package Lab5.design_patterns_revisited.revisited.factory_method;

public class Main {
    public static void main(String[] args) {
        NotificationService email = new EmailService();
        email.notifyUser("Hello via Email");

        NotificationService push = () -> new PushNotification();
        push.notifyUser("Hello via Push");
    }
}
