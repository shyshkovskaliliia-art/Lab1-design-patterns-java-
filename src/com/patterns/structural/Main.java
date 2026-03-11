package com.patterns.structural;

import com.patterns.structural.adapter.*;
import com.patterns.structural.bridge.*;
import com.patterns.structural.composite.*;
import com.patterns.structural.decorator.*;
import com.patterns.structural.facade.*;
import com.patterns.structural.flyweight.*;
import com.patterns.structural.proxy.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // --- 1. ADAPTER ---
        System.out.println("=== 1. ADAPTER ===");
        new Laptop("Asus ZenBook").connect(new UsbAToUsbCAdapter(new UsbADevice("Printer")));
        System.out.println();

        // --- 2. BRIDGE ---
        System.out.println("=== 2. BRIDGE ===");
        GroupLeader boss = new GroupLeader("Gandalf", new Mage());
        boss.orderGroupAttack();
        System.out.println();

        // --- 3. COMPOSITE ---
        System.out.println("=== 3. COMPOSITE ===");
        Trunk tree = new Trunk("Birch", 10, 5.0, 200);
        tree.addBranch(new Branch("Side Branch", 100, 15));
        tree.display(0);
        System.out.println();

        // --- 4. DECORATOR ---
        System.out.println("=== 4. DECORATOR ===");
        Notifier n = new SlackDecorator(new BasicNotifier());
        n.send("Low disk space!");
        System.out.println();

        // --- 5. FACADE ---
        System.out.println("=== 5. FACADE ===");
        OrderFacade shop = new OrderFacade();
        shop.placeOrder("Petro", "petro@test.com", "067", "Миша Logitech MX3", 1, 3000, "1234123412341234", "Львів", "Центр", 0.2);
        System.out.println();

        // --- 6. FLYWEIGHT ---
        System.out.println("=== 6. FLYWEIGHT ===");
        Spreadsheet.buildBudgetReport(3).render();
        System.out.println();

        // --- 7. PROXY ---
        System.out.println("=== 7. PROXY (Weather Service) ===");

        // Створюємо ланцюжок: Real API -> Cache -> Auth -> Rate Limit
        WeatherApi realService = new RealWeatherApi();
        WeatherApi cached = new CachingProxy(realService);
        WeatherApi authenticated = new AuthProxy(cached, "PREM-GOLD");
        WeatherApi protectedApi = new RateLimitProxy(authenticated, 2); // ліміт 2 запити на хв

        System.out.println("--- Перший запит (MISS, піде в реальне API) ---");
        System.out.println(protectedApi.getCurrentWeather("Київ"));

        System.out.println("\n--- Другий запит (HIT, візьме з кешу) ---");
        System.out.println(protectedApi.getCurrentWeather("Київ"));

        System.out.println("\n--- Третій запит (RATE LIMIT, перевищено ліміт 2/хв) ---");
        System.out.println(protectedApi.getCurrentWeather("Київ"));

        System.out.println("\n--- Спроба доступу без преміум-ключа до прогнозу ---");
        WeatherApi freeApi = new AuthProxy(cached, "FREE-001");
        System.out.println(freeApi.getForecast("Львів", 3));

        System.out.println("\n" + "=".repeat(50));
        System.out.println(" ЛАБОРАТОРНА РОБОТА ЗАВЕРШЕНА УСПІШНО ");
        System.out.println("=".repeat(50));
    }

}
