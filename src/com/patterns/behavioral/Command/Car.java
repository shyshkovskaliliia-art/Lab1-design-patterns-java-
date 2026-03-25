package com.patterns.behavioral.Command;

public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void changeOil() {
        System.out.println("СТО: У автомобілі " + model + " замінено мастило.");
    }

    public void repairBrakes() {
        System.out.println("СТО: Гальмівну систему автомобіля " + model + " відремонтовано.");
    }
}
