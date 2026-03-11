package com.patterns.structural.decorator;

public class Shake implements Animal  {
    @Override public String getName()        { return "Змія"; }
    @Override public double getDangerLevel() { return 6.0; }

    @Override
    public String getDescription() {
        return "Змія (Serpentes) — плазун із м'язовим тілом без кінцівок";
    }

    @Override
    public String hunt() {
        return "безшумно підкрадається та стискає здобич тілом";
    }

    @Override
    public String defend() {
        return "приймає загрозливу позу й шипить";
    }

    @Override
    public String sound() {
        return "ШШШШ... 🐍";
    }
}
