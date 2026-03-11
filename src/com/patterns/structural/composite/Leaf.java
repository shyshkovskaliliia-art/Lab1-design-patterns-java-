package com.patterns.structural.composite;

public class Leaf extends TreeComponent {
    private final double area;      // площа фотосинтезу, см²
    private final double weight;    // маса, г
    private String color;
    private boolean alive;

    public Leaf(String name, double area, double weight, String color) {
        super(name);
        this.area   = area;
        this.weight = weight;
        this.color  = color;
        this.alive  = true;
    }

    @Override
    public double getPhotosynthesisArea() {
        return alive ? area : 0;
    }

    @Override
    public int countLeaves() {
        return alive ? 1 : 0;
    }

    @Override
    public double getWeight() {
        return alive ? weight : weight * 0.3; // сухий лист легший
    }

    @Override
    public void display(int indent) {
        String status = alive ? "🍃" : "🍂";
        System.out.printf("%s%s %-20s  колір=%-10s  площа=%.1f см²  маса=%.2f г%n",
                indent(indent), status, name, color, area, getWeight());
    }

    @Override
    public void seasonChange(String season) {
        switch (season.toLowerCase()) {
            case "осінь" -> {
                color = "жовтий/червоний";
                System.out.println(indent(4) + "  🍂 " + name + " змінює колір на " + color);
            }
            case "зима" -> {
                alive = false;
                System.out.println(indent(4) + "  ❄  " + name + " опав");
            }
            case "весна" -> {
                alive = true;
                color = "світло-зелений";
                System.out.println(indent(4) + "  🌱 " + name + " розпустився (бруньки)");
            }
            case "літо" -> {
                color = "темно-зелений";
                System.out.println(indent(4) + "  ☀  " + name + " у повному розквіті");
            }
        }
    }
}
