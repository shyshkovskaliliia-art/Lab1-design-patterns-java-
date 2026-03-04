package com.patterns.creational.factory;

public class Plane implements Transport {
    @Override
    public void deliver() {
        System.out.println("Доставка літаком по повітрю");
    }
    @Override
    public String getType() { return "Plane"; }
}