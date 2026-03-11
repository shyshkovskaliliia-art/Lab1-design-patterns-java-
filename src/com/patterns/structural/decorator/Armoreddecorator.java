package com.patterns.structural.decorator;

public class Armoreddecorator extends AnimalDecorator {
    public ArmoredDecorator(Animal animal) {
        super(animal);
    }

    @Override
    public String getDescription() {
        return animal.getDescription() + " | захисна броня (товщина 15 мм)";
    }

    @Override
    public double getDangerLevel() {
        return Math.min(animal.getDangerLevel() + 2.0, 10.0);
    }

    @Override
    public String defend() {
        return animal.defend()
                + " + активує кістяний панцир, що витримує 500 кг/см²";
    }

    @Override
    public String hunt() {
        return animal.hunt()
                + " + врізається в здобич як живий таран (маса +40%)";
    }

    @Override
    public String sound() {
        return animal.sound() + " [металевий гуркіт броні]";
    }
}
