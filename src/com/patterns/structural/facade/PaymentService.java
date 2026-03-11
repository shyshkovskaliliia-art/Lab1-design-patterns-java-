package com.patterns.structural.facade;

public class PaymentService {
    public boolean authorizeCard(String cardNumber, double amount) {
        // Імітація перевірки картки
        boolean valid = cardNumber != null
                && cardNumber.length() == 16
                && !cardNumber.startsWith("0000");
        System.out.printf("  [Оплата] Авторизація картки *%s: %.2f грн — %s%n",
                cardNumber.substring(12), amount, valid ? "СХВАЛЕНО" : "ВІДХИЛЕНО");
        return valid;
    }

    public String charge(String cardNumber, double amount) {
        String transactionId = "TXN-" + Math.abs(cardNumber.hashCode() % 1_000_000);
        System.out.printf("  [Оплата] Списано %.2f грн. Транзакція: %s%n",
                amount, transactionId);
        return transactionId;
    }

    public void refund(String transactionId, double amount) {
        System.out.printf("  [Оплата] Повернення %.2f грн по транзакції %s — ВИКОНАНО%n",
                amount, transactionId);
    }
}
