package com.patterns.behavioral.Strategy;

public interface PaymentStrategy {
    void collectPaymentDetails();
    void pay(int amount);
}
