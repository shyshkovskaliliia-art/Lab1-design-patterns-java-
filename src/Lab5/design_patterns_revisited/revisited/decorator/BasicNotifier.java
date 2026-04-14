package Lab5.design_patterns_revisited.revisited.decorator;

public class BasicNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
