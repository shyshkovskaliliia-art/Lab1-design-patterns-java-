package com.patterns.structural.bridge;

public class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }
    @Override
    public void draw() {
        System.out.println("Малюємо коло, використовуємо " + color.fill());
    }
}
