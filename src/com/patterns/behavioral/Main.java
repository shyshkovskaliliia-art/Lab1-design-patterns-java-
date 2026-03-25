package com.patterns.behavioral;

import com.patterns.behavioral.ChainOfResponsibility.*;
import com.patterns.behavioral.Command.*;
import com.patterns.behavioral.Iterator.*;
import com.patterns.behavioral.Mediator.*;
import com.patterns.behavioral.Memento.*;
import com.patterns.behavioral.Observer.*;
import com.patterns.behavioral.State.*;
import com.patterns.behavioral.Strategy.*;
import com.patterns.behavioral.TemplateMethod.*;
import com.patterns.behavioral.Visitor.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. Chain of Responsibility (University) ===");
        UniversityHandler elder = new Elder();
        UniversityHandler lecturer = new Lecturer();
        UniversityHandler dean = new Dean();
        elder.setNext(lecturer);
        lecturer.setNext(dean);
        elder.handle(new StudentRequest("Лілія", "ООП", 2));
        System.out.println();

        System.out.println("=== 2. Command (Car Service) ===");
        com.patterns.behavioral.Command.Car commandCar = new com.patterns.behavioral.Command.Car("Tesla Model 3");
        Mechanic mechanic = new Mechanic();
        mechanic.takeOrder(new OilChangeCommand(commandCar));
        mechanic.takeOrder(new BrakeRepairCommand(commandCar));
        System.out.println();

        System.out.println("=== 3. Iterator (Spotify) ===");
        Playlist playlist = new Playlist();
        playlist.addSong(new Song("Blinding Lights", "The Weeknd"));
        playlist.addSong(new Song("Nightcall", "Kavinsky"));
        Iterator songIterator = playlist.createIterator();
        while (songIterator.hasNext()) {
            System.out.println("Відтворюється: " + songIterator.next());
        }
        System.out.println();

        System.out.println("=== 4. Mediator (Traffic Control) ===");
        TrafficMediator controller = new TrafficController();
        com.patterns.behavioral.Mediator.Car mediatorCar = new com.patterns.behavioral.Mediator.Car(controller, "Audi");
        Pedestrian p1 = new Pedestrian(controller, "Олексій");
        mediatorCar.tryToPass();
        p1.tryToPass();
        System.out.println();

        System.out.println("=== 5. Memento (Git) ===");
        GitFile file = new GitFile();
        GitHistory history = new GitHistory();
        file.setContent("Version 1: Initial code");
        history.push(file.save());
        file.setContent("Version 2: Added features");
        System.out.println("Поточний стан: " + file.getContent());
        file.restore(history.pop());
        System.out.println();

        System.out.println("=== 6. Observer (Order Notifications) ===");
        Order order = new Order(101);
        order.registerObserver(new EmailNotifier("liliia@example.com"));
        order.registerObserver(new SmsNotifier("+380990000000"));
        order.setStatus("Відправлено");
        System.out.println();

        System.out.println("=== 7. State (Game Player) ===");
        Player player = new Player();
        player.attack();
        player.setState(new InjuredState());
        player.move();
        System.out.println();

        System.out.println("=== 8. Strategy (E-Shop Payment) ===");
        ShoppingCart cart = new ShoppingCart();
        cart.addProductPrice(500);
        cart.checkout(new PayPalPayment("user@example.com"));
        System.out.println();

        System.out.println("=== 9. Template Method (Registration) ===");
        RegistrationTemplate reg = new EmailRegistration();
        reg.registerUser();
        System.out.println();

        System.out.println("=== 10. Visitor (File System) ===");
        Directory root = new Directory("Documents");
        root.addElement(new com.patterns.behavioral.Visitor.File("resume.pdf", 120));
        root.addElement(new com.patterns.behavioral.Visitor.File("image.png", 2500));
        SizeCalculator calc = new SizeCalculator();
        root.accept(calc);
        System.out.println("Загальний розмір: " + calc.getTotalSize() + " КБ");
    }

}
