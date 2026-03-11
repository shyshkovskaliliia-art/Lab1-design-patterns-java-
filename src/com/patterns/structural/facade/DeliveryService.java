package com.patterns.structural.facade;

public class DeliveryService {
    public double calculateShipping(String city, double weightKg) {
        double base = city.equalsIgnoreCase("Київ") ? 50.0 : 80.0;
        double cost = base + weightKg * 15.0;
        System.out.printf("  [Доставка] Розрахунок до «%s», вага %.1f кг: %.2f грн%n",
                city, weightKg, cost);
        return cost;
    }

    public String createShipment(String orderId, String address) {
        String trackingCode = "UA" + orderId.hashCode() % 100_000_000;
        System.out.printf("  [Доставка] Відправлення %s створено. Трек: %s%n",
                orderId, trackingCode);
        System.out.printf("  [Доставка] Адреса: %s%n", address);
        return trackingCode;
    }

    public void cancelShipment(String trackingCode) {
        System.out.printf("  [Доставка] Відправлення %s скасовано%n", trackingCode);
    }
}
