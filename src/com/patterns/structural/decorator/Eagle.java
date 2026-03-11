package com.patterns.structural.decorator;

public class Eagle implements Animal {
    @Override public String getName()        { return "Орел"; }
    @Override public double getDangerLevel() { return 5.5; }

    @Override
    public String getDescription() {
        return "Орел (Aquila chrysaetos) — гірський пернатий хижак";
    }

    @Override
    public String hunt() {
        return "пікірує з висоти 1000 м зі швидкістю 300 км/год";
    }

    @Override
    public String defend() {
        return "відлякує гострими кігтями та кліком";
    }

    @Override
    public String sound() {
        return "КЛІЙ-КЛІЙ! 🦅";
    }
}
