package com.patterns.behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class Order implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String status;
    private int orderId;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println("Замовлення #" + orderId + ": Статус змінено на '" + status + "'");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }
}
