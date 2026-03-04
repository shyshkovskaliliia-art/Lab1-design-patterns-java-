package com.patterns.creational.abstract_factory;

public class WindowsButton implements Button {
    @Override public void render() { System.out.println("[Windows] Кнопка відрендерена"); }
    @Override public void onClick() { System.out.println("[Windows] Кнопка натиснута"); }
}