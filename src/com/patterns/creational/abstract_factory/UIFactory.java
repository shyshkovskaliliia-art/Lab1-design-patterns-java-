package com.patterns.creational.abstract_factory;

public interface UIFactory {
    Button createButton();
    TextField createTextField();
    Checkbox createCheckbox();
}