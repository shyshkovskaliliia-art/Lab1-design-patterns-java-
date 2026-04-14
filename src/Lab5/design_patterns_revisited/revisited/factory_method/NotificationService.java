package Lab5.design_patterns_revisited.revisited.factory_method;

@FunctionalInterface
public interface NotificationService {
    Notification createNotification();

    default void notifyUser(String message) {
        createNotification().notifyUser(message);
    }
}
