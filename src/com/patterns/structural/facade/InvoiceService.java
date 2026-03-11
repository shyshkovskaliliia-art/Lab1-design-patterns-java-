package com.patterns.structural.facade;

import java.time.LocalDate;

public class InvoiceService {
    public String generateInvoice(String orderId, String customer,
                                  String item, int qty, double total) {
        String invoiceId = "INV-" + orderId;
        System.out.printf("  [Рахунок] %s | Клієнт: %s | %s%n", invoiceId, customer, LocalDate.now());
        System.out.printf("  [Рахунок] %d x %s = %.2f грн%n", qty, item, total);
        System.out.printf("  [Рахунок] Фіскальний чек збережено в архів%n");
        return invoiceId;
    }

    public void voidInvoice(String invoiceId) {
        System.out.printf("  [Рахунок] %s анульовано%n", invoiceId);
    }
}
