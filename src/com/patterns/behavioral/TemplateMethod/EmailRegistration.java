package com.patterns.behavioral.TemplateMethod;

public class EmailRegistration extends RegistrationTemplate {
    @Override
    protected void validateData() {
        System.out.println("Email-реєстрація: Перевірка формату пошти та складності пароля.");
    }

    @Override
    protected void enterCredentials() {
        System.out.println("Email-реєстрація: Користувач ввів логін та пароль.");
    }

    @Override
    protected void sendWelcomeMessage() {
        System.out.println("Email-реєстрація: Надіслано лист для підтвердження на пошту.");
    }
}
