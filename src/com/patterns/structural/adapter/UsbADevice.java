package com.patterns.structural.adapter;

public class UsbADevice {
    private String name;

    public UsbADevice(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void plugInUsbA() {
        System.out.println("  [" + name + "] USB-A штекер вставлено у порт");
    }

    public String sendDataUsbA(String data) {
        return "[USB-A] " + data + " (швидкість: 480 Мбіт/с)";
    }
}
