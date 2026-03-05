package com.patterns.creational.abstract_factory;

public record UserInterface(Button button, TextField textField, Checkbox checkbox) {

    public static class FactoryMaker {
        public static UIFactory makeFactory(OSType type) {
            return switch (type) {
                case WINDOWS -> new WindowsFactory();
                case MAC     -> new MacFactory();
            };
        }
    }
}