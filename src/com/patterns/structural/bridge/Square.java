package com.patterns.structural.bridge;

public class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Малюємо квадрат, використовуємо " + color.fill());
    }
}
