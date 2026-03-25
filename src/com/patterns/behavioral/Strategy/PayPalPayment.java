package com.patterns.behavioral.Strategy;

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Авторизація в системі PayPal для: " + email);
    }

    @Override
    public void pay(int amount) {
        System.out.println("Оплачено " + amount + " грн через PayPal.");
    }
}
