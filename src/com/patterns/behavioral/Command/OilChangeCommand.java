package com.patterns.behavioral.Command;

public class OilChangeCommand implements Command {
    private Car car;

    public OilChangeCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.changeOil();
    }
}
