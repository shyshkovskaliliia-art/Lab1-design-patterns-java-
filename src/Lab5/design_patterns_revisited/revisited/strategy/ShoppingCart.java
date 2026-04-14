package Lab5.design_patterns_revisited.revisited.strategy;

public class ShoppingCart {
    private int totalAmount = 0;

    public void addProductPrice(int price) {
        totalAmount += price;
    }

    public void checkout(PaymentStrategy paymentMethod) {
        paymentMethod.collectPaymentDetails();
        paymentMethod.pay(totalAmount);
    }
}
