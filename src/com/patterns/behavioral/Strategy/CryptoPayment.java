package com.patterns.behavioral.Strategy;

public class CryptoPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Перевірка адреси гаманця: " + walletAddress);
    }

    @Override
    public void pay(int amount) {
        System.out.println("Оплачено " + amount + " грн за допомогою Bitcoin.");
    }
}
