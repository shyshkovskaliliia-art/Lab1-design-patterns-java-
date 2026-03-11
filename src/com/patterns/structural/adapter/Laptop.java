package com.patterns.structural.adapter;

public class Laptop {
    private String model;

    public Laptop(String model) {
        this.model = model;
    }

    public void connect(UsbCPort port) {
        System.out.println("  [" + model + "] Підключаємо пристрій через USB-C...");
        port.connectUsbC();
    }

    public void readData(UsbCPort port, String data) {
        String result = port.transferData(data);
        System.out.println("  [" + model + "] Отримано: " + result);
    }
}
