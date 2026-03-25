package com.patterns.behavioral.Mediator;

public class Car extends Participant {
    public Car(TrafficMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void move() {
        System.out.println("Автомобіль " + name + " проїжджає перехрестя.");
    }

    public void tryToPass() {
        System.out.println("Автомобіль " + name + " запитує дозвіл на проїзд.");
        mediator.requestPass(this);
    }
}
