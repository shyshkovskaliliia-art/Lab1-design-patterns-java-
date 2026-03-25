package com.patterns.behavioral.TemplateMethod;

public abstract class RegistrationTemplate {
    public final void registerUser() {
        validateData();
        enterCredentials();
        saveToDatabase();
        sendWelcomeMessage();
        System.out.println("--- Реєстрацію завершено успішно! ---");
    }

    private void saveToDatabase() {
        System.out.println("Система: Користувача збережено в базу даних.");
    }

    protected abstract void validateData();
    protected abstract void enterCredentials();
    protected abstract void sendWelcomeMessage();
}
