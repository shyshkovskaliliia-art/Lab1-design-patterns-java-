package com.patterns.structural.decorator;

public class Lion implements Animal{
    @Override public String getName()        { return "Лев"; }
    @Override public double getDangerLevel() { return 7.5; }

    @Override
    public String getDescription() {
        return "Лев (Panthera leo) — великий африканський хижак";
    }

    @Override
    public String hunt() {
        return "переслідує здобич у савані на швидкості до 80 км/год";
    }

    @Override
    public String defend() {
        return "відлякує ворогів гривою та гучним ревом";
    }

    @Override
    public String sound() {
        return "РОАР! ";
    }
}
