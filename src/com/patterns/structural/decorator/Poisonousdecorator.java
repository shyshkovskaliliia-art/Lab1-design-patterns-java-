package com.patterns.structural.decorator;

public class Poisonousdecorator extends AnimalDecorator {
    private String toxinName;
    private int    lethalDoseMs;  // летальна доза, мс на кг

    public PoisonousDecorator(Animal animal, String toxinName, int lethalDoseMs) {
        super(animal);
        this.toxinName    = toxinName;
        this.lethalDoseMs = lethalDoseMs;
    }

    @Override
    public String getDescription() {
        return animal.getDescription()
                + String.format(" | отруйний [%s, LD50=%d мс/кг]", toxinName, lethalDoseMs);
    }

    @Override
    public double getDangerLevel() {
        return Math.min(animal.getDangerLevel() + 2.5, 10.0);
    }

    @Override
    public String hunt() {
        return animal.hunt()
                + " + вводить " + toxinName + ", що паралізує жертву за 3 сек";
    }

    @Override
    public String defend() {
        return animal.defend()
                + " + виприскує " + toxinName + " на відстань до 2 метрів";
    }

    @Override
    public String sound() {
        return animal.sound() + " danger!";
    }
}
