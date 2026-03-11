package com.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Branch extends TreeComponent{
    private double ownWeight;   // маса самої деревини, г
    private int    thickness;   // товщина, мм
    private List<TreeComponent> children = new ArrayList<>();

    public Branch(String name, double ownWeight, int thickness) {
        super(name);
        this.ownWeight = ownWeight;
        this.thickness = thickness;
    }

    public void add(TreeComponent component) {
        children.add(component);
    }

    public void remove(TreeComponent component) {
        children.remove(component);
    }

    @Override
    public double getPhotosynthesisArea() {
        return children.stream()
                .mapToDouble(TreeComponent::getPhotosynthesisArea)
                .sum();
    }

    @Override
    public int countLeaves() {
        return children.stream()
                .mapToInt(TreeComponent::countLeaves)
                .sum();
    }

    @Override
    public double getWeight() {
        double childrenWeight = children.stream()
                .mapToDouble(TreeComponent::getWeight)
                .sum();
        return ownWeight + childrenWeight;
    }

    @Override
    public void display(int indent) {
        System.out.printf("%s🌿 %-20s  товщина=%d мм  листків=%d  фотосинтез=%.1f см²%n",
                indent(indent), name, thickness, countLeaves(), getPhotosynthesisArea());
        for (TreeComponent child : children) {
            child.display(indent + 1);
        }
    }

    @Override
    public void seasonChange(String season) {
        System.out.println(indent(2) + "↳ Гілка «" + name + "» передає сезон: " + season);
        for (TreeComponent child : children) {
            child.seasonChange(season);
        }
    }
}
