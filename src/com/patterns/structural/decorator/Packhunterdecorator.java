package com.patterns.structural.decorator;

public class Packhunterdecorator extends AnimalDecorator {
    private int packSize; // розмір зграї

    public PackHunterDecorator(Animal animal, int packSize) {
        super(animal);
        this.packSize = packSize;
    }

    @Override
    public String getDescription() {
        return animal.getDescription()
                + " | зграйний мисливець (зграя: " + packSize + " особин)";
    }

    @Override
    public double getDangerLevel() {
        // Небезпека зростає логарифмічно від розміру зграї
        return Math.min(animal.getDangerLevel() + Math.log(packSize), 10.0);
    }

    @Override
    public String hunt() {
        return animal.hunt()
                + " + координує оточення зі зграєю (" + packSize
                + " особин), відрізаючи шляхи втечі";
    }

    @Override
    public String defend() {
        return animal.defend()
                + " + зграя миттєво стягується на захист [" + packSize + " × сила]";
    }

    @Override
    public String sound() {
        return animal.sound() + " x" + packSize + " [ехо зграї]";
    }
}
