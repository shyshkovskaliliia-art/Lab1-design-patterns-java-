package com.patterns.structural.composite;

public abstract class TreeComponent {
    protected String name;

    public TreeComponent(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public abstract double getPhotosynthesisArea();
    public abstract int countLeaves();
    public abstract double getWeight();
    public abstract void display(int indent);
    public abstract void seasonChange(String season);
    protected String indent(int n) {
        return "  ".repeat(n);
    }
}
