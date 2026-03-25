package com.patterns.behavioral.Command;

public class BrakeRepairCommand implements Command {
    private Car car;

    public BrakeRepairCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.repairBrakes();
    }
}
