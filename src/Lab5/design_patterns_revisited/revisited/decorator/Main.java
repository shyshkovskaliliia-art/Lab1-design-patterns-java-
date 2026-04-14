package Lab5.design_patterns_revisited.revisited.decorator;
package com.patterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        String message = "Hello, World!";

        System.out.println("=== Classic Decorator ===");
        Notifier classic = new BasicNotifier();
        classic = new FacebookDecorator(classic);
        classic = new SlackDecorator(classic);
        classic.send(message);

        System.out.println("\n=== Functional Decorator ===");
        Notifier functional = NotifierDecorator.decorate(
                NotifierDecorator.BASIC,
                NotifierDecorator.withFacebook,
                NotifierDecorator.withSlack
        );
        functional.send(message);
    }
}
