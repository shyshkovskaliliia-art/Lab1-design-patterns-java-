package com.patterns.structural.facade;

public class OrderResult {
    public final boolean  success;
    public final String   orderId;
    public final String   transactionId;
    public final String   trackingCode;
    public final String   invoiceId;
    public final double   totalPaid;
    public final String   message;

    public OrderResult(boolean success, String orderId, String transactionId,
                       String trackingCode, String invoiceId,
                       double totalPaid, String message) {
        this.success       = success;
        this.orderId       = orderId;
        this.transactionId = transactionId;
        this.trackingCode  = trackingCode;
        this.invoiceId     = invoiceId;
        this.totalPaid     = totalPaid;
        this.message       = message;
    }

    @Override
    public String toString() {
        if (!success) return "  ✗ Замовлення не виконано: " + message;
        return String.format(
                "  ✓ Замовлення %s оформлено!%n" +
                        "    Транзакція : %s%n" +
                        "    Трек-номер : %s%n" +
                        "    Рахунок    : %s%n" +
                        "    Сплачено   : %.2f грн",
                orderId, transactionId, trackingCode, invoiceId, totalPaid);
    }
}
