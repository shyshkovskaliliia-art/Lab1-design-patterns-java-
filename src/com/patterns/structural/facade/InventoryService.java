package com.patterns.structural.facade;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    public InventoryService() {
        stock.put("Ноутбук Dell XPS 15",   5);
        stock.put("Миша Logitech MX3",     12);
        stock.put("Клавіатура Keychron K2", 8);
        stock.put("Монітор LG 27\" 4K",     3);
        stock.put("Навушники Sony WH-1000", 7);
    }

    public boolean checkAvailability(String item, int quantity) {
        int available = stock.getOrDefault(item, 0);
        System.out.printf("  [Склад] Перевірка «%s»: є %d шт., потрібно %d — %s%n",
                item, available, quantity, available >= quantity ? "OK" : "НЕМАЄ");
        return available >= quantity;
    }

    public void reserve(String item, int quantity) {
        stock.merge(item, -quantity, Integer::sum);
        System.out.printf("  [Склад] Зарезервовано %d x «%s» (залишок: %d)%n",
                quantity, item, stock.get(item));
    }

    public void release(String item, int quantity) {
        stock.merge(item, quantity, Integer::sum);
        System.out.printf("  [Склад] Повернуто %d x «%s» на склад%n", quantity, item);
    }
}
