package com.patterns.creational.abstract_factory;

public class MacCheckbox implements Checkbox {
    @Override public void render() { System.out.println("[Mac] Чекбокс відрендерено"); }
    @Override public void onToggle() { System.out.println("[Mac] Чекбокс перемкнуто"); }
}