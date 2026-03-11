package com.patterns.structural.decorator;

public class Nocturnaldecorator extends AnimalDecorator {
    public NocturnalDecorator(Animal animal) {
        super(animal);
    }

    @Override
    public String getDescription() {
        return animal.getDescription() + " | нічна адаптація (інфрачервоний зір)";
    }

    @Override
    public double getDangerLevel() {
        return Math.min(animal.getDangerLevel() + 1.5, 10.0);
    }

    @Override
    public String hunt() {
        return animal.hunt()
                + " + переходить на нічне полювання, використовуючи термозір";
    }

    @Override
    public String defend() {
        return animal.defend()
                + " + ховається в темряві, залишаючись непомітним";
    }

    @Override
    public String sound() {
        return "[тиша... потім раптово] " + animal.sound();
    }
}
