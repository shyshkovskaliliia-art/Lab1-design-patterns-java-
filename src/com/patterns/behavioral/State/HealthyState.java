package com.patterns.behavioral.State;

public class HealthyState implements State {
    @Override
    public void move() {
        System.out.println("Гравець біжить на повній швидкості.");
    }

    @Override
    public void attack() {
        System.out.println("Гравець завдає сильного удару мечем!");
    }
}
