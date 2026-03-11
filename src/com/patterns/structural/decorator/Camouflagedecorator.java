package com.patterns.structural.decorator;

public class Camouflagedecorator extends AnimalDecorator {
    private String environment; // середовище: ліс, пустеля, сніг...

    public CamouflageDecorator(Animal animal, String environment) {
        super(animal);
        this.environment = environment;
    }

    @Override
    public String getDescription() {
        return animal.getDescription()
                + " | активний камуфляж під «" + environment + "»";
    }

    @Override
    public double getDangerLevel() {
        return Math.min(animal.getDangerLevel() + 1.0, 10.0);
    }

    @Override
    public String hunt() {
        return animal.hunt()
                + " + стає повністю невидимим у " + environment
                + " завдяки хроматофорам";
    }

    @Override
    public String defend() {
        return animal.defend()
                + " + миттєво зливається з тлом " + environment;
    }

    @Override
    public String sound() {
        return "[з тіні] " + animal.sound();
    }
}
