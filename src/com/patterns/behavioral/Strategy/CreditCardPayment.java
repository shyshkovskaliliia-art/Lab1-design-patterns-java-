package com.patterns.behavioral.Strategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String date;
    private String cvv;

    public CreditCardPayment(String cardNumber, String date, String cvv) {
        this.cardNumber = cardNumber;
        this.date = date;
        this.cvv = cvv;
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Перевірка даних картки: " + cardNumber);
    }

    @Override
    public void pay(int amount) {
        System.out.println("Оплачено " + amount + " грн за допомогою Credit Card.");
    }
}
