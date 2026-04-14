package Lab5.design_patterns_revisited.revisited.factory_method;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
