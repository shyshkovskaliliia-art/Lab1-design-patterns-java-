package com.patterns.creational.abstract_factory;

public class MacButton implements Button {
    @Override public void render() { System.out.println("[Mac] Кнопка відрендерена"); }
    @Override public void onClick() { System.out.println("[Mac] Кнопка натиснута"); }
}