package com.patterns.structural.bridge;

public abstract class Shape {
    protected Color color; // "Міст" до інтерфейсу Color

    protected Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
