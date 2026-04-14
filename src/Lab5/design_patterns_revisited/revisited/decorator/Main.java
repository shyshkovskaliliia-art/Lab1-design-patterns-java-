package Lab5.design_patterns_revisited.revisited.decorator;

public class Main {
    public static void main(String[] args) {
        String message = "Hello, World!";

        System.out.println("=== Classic Decorator (старий підхід) ===");
        com.patterns.structural.decorator.Notifier classic =
                new com.patterns.structural.decorator.BasicNotifier();
        classic = new com.patterns.structural.decorator.FacebookDecorator(classic);
        classic.send(message);

        System.out.println("\n=== Functional Decorator (новий підхід) ===");
        Notifier baseNotifier = new BasicNotifier();

        Notifier functionalNotifier = NotifierDecorator.decorate(
                baseNotifier,
                NotifierDecorator.withFacebook,
                NotifierDecorator.withSlack
        );
        functionalNotifier.send(message);
    }
}
