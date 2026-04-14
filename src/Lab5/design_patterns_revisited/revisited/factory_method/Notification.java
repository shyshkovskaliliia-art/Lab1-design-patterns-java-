package Lab5.design_patterns_revisited.revisited.factory_method;

public interface Notification {
    void send(String message);

    default void notifyUser(String message) {
        System.out.println("[LOG] Початок відправки...");
        send(message);
        System.out.println("[LOG] Відправлено успішно!");
    }
}
