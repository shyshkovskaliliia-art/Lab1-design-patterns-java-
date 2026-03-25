package com.patterns.behavioral.State;

public class InjuredState implements State {
    @Override
    public void move() {
        System.out.println("Гравець повільно шкутильгає.");
    }

    @Override
    public void attack() {
        System.out.println("Гравець слабко замахується з останніх сил.");
    }
}
