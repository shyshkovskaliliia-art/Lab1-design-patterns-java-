package com.patterns.creational.abstract_factory;

public class MacFactory implements UIFactory {
    @Override public Button createButton()       { return new MacButton(); }
    @Override public TextField createTextField() { return new MacTextField(); }
    @Override public Checkbox createCheckbox()   { return new MacCheckbox(); }
}