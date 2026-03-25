package com.patterns.behavioral.Mediator;

public abstract class Participant {
    protected TrafficMediator mediator;
    protected String name;

    public Participant(TrafficMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void move();
    public String getName() { return name; }
}
