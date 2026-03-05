package com.patterns;

import com.patterns.creational.singleton.Singleton;
import com.patterns.creational.factory.*;
import com.patterns.creational.factory_method.*;
import com.patterns.creational.abstract_factory.*;
import com.patterns.creational.builder.Pizza;
import com.patterns.creational.prototype.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("========== 1. SINGLETON ==========");
        Singleton db1 = Singleton.getInstance();
        Singleton db2 = Singleton.getInstance();
        System.out.println("Один об'єкт: " + (db1 == db2));
        System.out.println("URL: " + db1.getDatabaseUrl());
        db1.setDatabaseUrl("jdbc:postgresql://localhost/newdb");
        System.out.println("db2 бачить зміну: " + db2.getDatabaseUrl());

        System.out.println("\n========== 2. FACTORY ==========");
        Transport truck = TransportFactory.create("truck");
        Transport ship  = TransportFactory.create("ship");
        Transport plane = TransportFactory.create("plane");
        truck.deliver();
        ship.deliver();
        plane.deliver();

        // ===== 3. FACTORY METHOD =====
        System.out.println("\n========== 3. FACTORY METHOD ==========");
        NotificationService email = new EmailService();
        NotificationService sms   = new SmsService();
        NotificationService push  = new PushService();
        email.notifyUser("Акаунт підтверджено!");
        sms.notifyUser("Код: 1234");
        push.notifyUser("Нове повідомлення");

        // ===== 4. ABSTRACT FACTORY =====
        System.out.println("\n========== 4. ABSTRACT FACTORY ==========");
        System.out.println("-- Windows --");
        UIFactory win = new WindowsFactory();
        win.createButton().render();
        win.createTextField().onInput("Привіт");
        win.createCheckbox().onToggle();

        System.out.println("-- Mac --");
        UIFactory mac = new MacFactory();
        mac.createButton().render();
        mac.createTextField().onInput("Привіт");
        mac.createCheckbox().onToggle();

        // ===== 5. BUILDER =====
        System.out.println("\n========== 5. BUILDER ==========");
        Pizza p1 = new Pizza.Builder("Large", "Thin")
                .sauce("Томатний").cheese("Моцарела")
                .toppings(List.of("Базилік", "Оливки"))
                .extraCheese(false).build();
        System.out.println(p1);

        Pizza p2 = new Pizza.Builder("XL", "Thick")
                .sauce("BBQ").cheese("Чеддер")
                .toppings(List.of("Курка", "Цибуля"))
                .extraCheese(true).build();
        System.out.println(p2);

        // ===== 6. PROTOTYPE =====
        System.out.println("\n========== 6. PROTOTYPE ==========");
        Circle c1 = new Circle("Червоний", 10, 20, 5.0);
        Circle c2 = (Circle) c1.clone();

        c2.setColor("Синій");
        c2.setRadius(8.0);
        System.out.println("Оригінал: " + c1);
        System.out.println("Клон:     " + c2);

        Rectangle r1 = new Rectangle("Зелений", 0, 0, 10, 5);
        Rectangle r2 = (Rectangle) r1.clone();
        r2.setColor("Жовтий");
        System.out.println("Оригінал: " + r1);
        System.out.println("Клон:     " + r2);
    }
}
