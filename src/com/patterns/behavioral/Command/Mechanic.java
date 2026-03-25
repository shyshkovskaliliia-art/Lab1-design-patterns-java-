package com.patterns.behavioral.Command;

import java.util.ArrayList;
import java.util.List;

public class Mechanic {
    private List<Command> orderHistory = new ArrayList<>();

    public void takeOrder(Command command) {
        orderHistory.add(command);
        command.execute();
    }
}
