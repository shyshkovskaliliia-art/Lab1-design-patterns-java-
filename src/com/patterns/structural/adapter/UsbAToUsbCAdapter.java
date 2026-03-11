package com.patterns.structural.adapter;

public class UsbAToUsbCAdapter implements UsbCPort {
    private UsbADevice device;

    public UsbAToUsbCAdapter(UsbADevice device) {
        this.device = device;
    }

    @Override
    public void connectUsbC() {
        System.out.println("  [Adapter USB-A→C] Перехідник активовано для: " + device.getName());
        device.plugInUsbA();
    }

    @Override
    public String transferData(String data) {
        System.out.println("  [Adapter USB-A→C] Конвертуємо сигнал USB-C → USB-A...");
        return device.sendDataUsbA(data);
    }
}
