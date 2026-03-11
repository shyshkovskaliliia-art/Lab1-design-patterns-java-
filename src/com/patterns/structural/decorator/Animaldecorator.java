package com.patterns.structural.decorator;

public class Animaldecorator implements Animal {
    protected Animal animal;

    public AnimalDecorator(Animal animal) {
        this.animal = animal;
    }

    @Override public String getName()        { return animal.getName(); }
    @Override public String getDescription() { return animal.getDescription(); }
    @Override public double getDangerLevel() { return animal.getDangerLevel(); }
    @Override public String hunt()           { return animal.hunt(); }
    @Override public String defend()         { return animal.defend(); }
    @Override public String sound()          { return animal.sound(); }
}
