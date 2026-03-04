package com.patterns.creational.abstract_factory;

public class WindowsFactory implements UIFactory {
    @Override public Button createButton()       { return new WindowsButton(); }
    @Override public TextField createTextField() { return new WindowsTextField(); }
    @Override public Checkbox createCheckbox()   { return new WindowsCheckbox(); }
}