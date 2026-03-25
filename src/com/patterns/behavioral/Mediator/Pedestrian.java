package com.patterns.behavioral.Mediator;

public class Pedestrian extends Participant {
    public Pedestrian(TrafficMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void move() {
        System.out.println("Пішохід " + name + " переходить дорогу.");
    }

    public void tryToPass() {
        System.out.println("Пішохід " + name + " запитує дозвіл на перехід.");
        mediator.requestPass(this);
    }
}
