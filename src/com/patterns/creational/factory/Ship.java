package com.patterns.creational.factory;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Доставка кораблем по морю");
    }
    @Override
    public String getType() { return "Ship"; }
}