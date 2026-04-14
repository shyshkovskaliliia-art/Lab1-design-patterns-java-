package Lab5.design_patterns_revisited.revisited.decorator;

@FunctionalInterface
public interface Notifier {
    void send(String message);
}
