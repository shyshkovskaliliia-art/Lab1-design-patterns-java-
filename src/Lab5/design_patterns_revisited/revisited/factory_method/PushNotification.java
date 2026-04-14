package Lab5.design_patterns_revisited.revisited.factory_method;

public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Push: " + message);
    }
}
