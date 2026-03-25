package com.patterns.behavioral.TemplateMethod;

public class SocialMediaRegistration extends RegistrationTemplate {
    @Override
    protected void validateData() {
        System.out.println("Social-реєстрація: Перевірка токена доступу від стороннього сервісу.");
    }

    @Override
    protected void enterCredentials() {
        System.out.println("Social-реєстрація: Отримання імені та фото з профілю соцмережі.");
    }

    @Override
    protected void sendWelcomeMessage() {
        System.out.println("Social-реєстрація: Надіслано Push-сповіщення про успішний вхід.");
    }
}
