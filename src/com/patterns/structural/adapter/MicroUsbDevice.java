package com.patterns.structural.adapter;

public class MicroUsbDevice {
    private String name;

    public MicroUsbDevice(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void plugInMicroUsb(){
        System.out.println("  [" + name + "] Micro-USB штекер вставлено у порт");
    }

    public String sendDataMicroUsb(String data){
        return "[Micro-USB] " + data + " (швидкість: 60 Мбіт/с)";
    }
}
