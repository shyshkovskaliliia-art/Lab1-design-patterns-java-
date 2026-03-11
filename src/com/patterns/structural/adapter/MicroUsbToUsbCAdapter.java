package com.patterns.structural.adapter;

public class MicroUsbToUsbCAdapter implements UsbCPort {
    private MicroUsbDevice device;

    public MicroUsbToUsbCAdapter(MicroUsbDevice device) {
        this.device = device;
    }

    @Override
    public void connectUsbC() {
        System.out.println("  [Adapter Micro-USB→C] Перехідник активовано для: " + device.getName());
        device.plugInMicroUsb();
    }

    @Override
    public String transferData(String data) {
        System.out.println("  [Adapter Micro-USB→C] Конвертуємо сигнал USB-C → Micro-USB...");
        return device.sendDataMicroUsb(data);
    }
}
