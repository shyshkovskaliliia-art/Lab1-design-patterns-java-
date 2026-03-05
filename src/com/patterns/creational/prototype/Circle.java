package com.patterns.creational.prototype;

import java.util.Objects;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, int x, int y, double radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public double area() { return Math.PI * radius * radius; }

    public void setRadius(double r) { this.radius = r; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }

    @Override
    public String toString() {
        return "Circle [color=" + color + ", x=" + x + ", y=" + y
                + ", radius=" + radius
                + ", area=" + String.format("%.2f", area()) + "]";
    }
}