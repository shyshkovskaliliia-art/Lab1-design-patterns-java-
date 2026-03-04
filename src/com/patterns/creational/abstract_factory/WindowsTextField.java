package com.patterns.creational.abstract_factory;

public class WindowsTextField implements TextField {
    @Override public void render() { System.out.println("[Windows] Текстове поле відрендерено"); }
    @Override public void onInput(String text) { System.out.println("[Windows] Введено: " + text); }
}