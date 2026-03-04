package com.patterns.creational.factory;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Доставка вантажівкою по дорозі");
    }
    @Override
    public String getType() { return "Truck"; }
}