package com.patterns.creational.prototype;

public abstract class Shape implements Cloneable {
    protected String color;
    protected int x, y;

    public Shape(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setColor(String color) { this.color = color; }
}