package com.patterns.creational.prototype;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) == 0 && Double.compare(height, rectangle.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Rectangle [color=" + color + ", x=" + x + ", y=" + y
                + ", width=" + width + ", height=" + height
                + ", area=" + String.format("%.2f", area()) + "]";
    }
}