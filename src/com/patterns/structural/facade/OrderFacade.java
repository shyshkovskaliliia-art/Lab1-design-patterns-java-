package com.patterns.structural.facade;

import java.util.UUID;

public class OrderFacade {
    private final InventoryService  inventory    = new InventoryService();
    private final PaymentService    payment      = new PaymentService();
    private final DeliveryService   delivery     = new DeliveryService();
    private final NotificationService notifications = new NotificationService();
    private final InvoiceService    invoice      = new InvoiceService();

    public OrderResult placeOrder(String customerName,
                                  String email,
                                  String phone,
                                  String item,
                                  int    quantity,
                                  double pricePerUnit,
                                  String cardNumber,
                                  String deliveryCity,
                                  String deliveryAddress,
                                  double weightKg) {

        String orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        System.out.println("\n  ── КРОК 1: Перевірка складу");

        if (!inventory.checkAvailability(item, quantity)) {
            return new OrderResult(false, orderId, null, null, null, 0,
                    "Товар «" + item + "» відсутній на складі");
        }
        inventory.reserve(item, quantity);

        System.out.println("\n  ── КРОК 2: Оплата ");
        double itemsTotal   = pricePerUnit * quantity;
        double shippingCost = delivery.calculateShipping(deliveryCity, weightKg);
        double total        = itemsTotal + shippingCost;

        if (!payment.authorizeCard(cardNumber, total)) {
            inventory.release(item, quantity);
            return new OrderResult(false, orderId, null, null, null, 0,
                    "Картка відхилена банком");
        }
        String transactionId = payment.charge(cardNumber, total);

        System.out.println("\n  ── КРОК 3: Оформлення доставки ");
        String trackingCode = delivery.createShipment(orderId, deliveryAddress);

        System.out.println("\n  ── КРОК 4: Рахунок-фактура ");
        String invoiceId = invoice.generateInvoice(
                orderId, customerName, item, quantity, total);

        System.out.println("\n  ── КРОК 5: Сповіщення клієнта ");
        notifications.sendEmail(email,
                "Ваше замовлення " + orderId + " оформлено",
                String.format("Дякуємо, %s! Очікуйте доставку. Трек: %s",
                        customerName, trackingCode));
        notifications.sendSms(phone,
                "Замовлення " + orderId + " прийнято. Трек: " + trackingCode);

        return new OrderResult(true, orderId, transactionId,
                trackingCode, invoiceId, total, "Успішно");
    }

    public void cancelOrder(String orderId,
                            String item,
                            int    quantity,
                            String transactionId,
                            double refundAmount,
                            String trackingCode,
                            String invoiceId,
                            String email,
                            String phone) {

        System.out.println("\n  ── СКАСУВАННЯ: повернення товару ");
        inventory.release(item, quantity);

        System.out.println("\n  ── СКАСУВАННЯ: повернення коштів ");
        payment.refund(transactionId, refundAmount);

        System.out.println("\n  ── СКАСУВАННЯ: зупинка доставки ");
        delivery.cancelShipment(trackingCode);

        System.out.println("\n  ── СКАСУВАННЯ: анулювання рахунку ");
        invoice.voidInvoice(invoiceId);

        System.out.println("\n  ── СКАСУВАННЯ: сповіщення клієнта");
        notifications.sendEmail(email,
                "Замовлення " + orderId + " скасовано",
                String.format("Кошти %.2f грн повернено на вашу картку.", refundAmount));
        notifications.sendSms(phone,
                "Замовлення " + orderId + " скасовано. Повернення: " + refundAmount + " грн.");
    }
}
