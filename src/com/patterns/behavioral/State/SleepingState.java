package com.patterns.behavioral.State;

public class SleepingState implements State {
    @Override
    public void move() {
        System.out.println("Гравець не може рухатися, він міцно спить.");
    }

    @Override
    public void attack() {
        System.out.println("Гравець бачить сни про битви, але не атакує.");
    }
}
