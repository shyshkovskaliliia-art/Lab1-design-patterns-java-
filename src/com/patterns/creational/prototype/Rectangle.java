package com.patterns.creational.prototype;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(String color, int x, int y, double width, double height) {
        super(color, x, y);
        this.width  = width;
        this.height = height;
    }

    @Override
    public double area() { return width * height; }

    @Override
    public String toString() {
        return "Rectangle [color=" + color + ", x=" + x + ", y=" + y
                + ", width=" + width + ", height=" + height
                + ", area=" + String.format("%.2f", area()) + "]";
    }
}