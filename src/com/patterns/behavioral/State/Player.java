package com.patterns.behavioral.State;

public class Player {
    private State state;

    public Player() {
        // Початковий стан — здоровий
        this.state = new HealthyState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void move() {
        state.move();
    }

    public void attack() {
        state.attack();
    }
}
