package com.patterns.creational.abstract_factory;

public class MacTextField implements TextField {
    @Override public void render() { System.out.println("[Mac] Текстове поле відрендерено"); }
    @Override public void onInput(String text) { System.out.println("[Mac] Введено: " + text); }
}