package com.patterns.creational.abstract_factory;

public class WindowsCheckbox implements Checkbox {
    @Override public void render() { System.out.println("[Windows] Чекбокс відрендерено"); }
    @Override public void onToggle() { System.out.println("[Windows] Чекбокс перемкнуто"); }
}