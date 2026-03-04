package com.patterns.creational.factory;

public class TransportFactory {
    public static Transport create(String type) {
        return switch (type.toLowerCase()) {
            case "truck" -> new Truck();
            case "ship"  -> new Ship();
            case "plane" -> new Plane();
            default -> throw new IllegalArgumentException("Невідомий тип: " + type);
        };
    }
}