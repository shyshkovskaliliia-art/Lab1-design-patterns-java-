package Lab5.design_patterns_revisited.revisited.strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProductPrice(100);
        cart.addProductPrice(250);

        PaymentStrategy creditCard = () -> {
            System.out.println("Перевірка даних картки: **** **** **** 1234");
            System.out.println("Оплачено " + 350 + " грн за допомогою Credit Card.");
        };
        cart.checkout(creditCard);

        String email = "user@example.com";
        PaymentStrategy payPal = () -> {
            System.out.println("Авторизація в системі PayPal для: " + email);
            System.out.println("Оплачено " + 350 + " грн через PayPal.");
        };
        cart.checkout(payPal);

        PaymentStrategy crypto = createCryptoPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
        cart.checkout(crypto);
    }

    private static PaymentStrategy createCryptoPayment(String wallet) {
        return () -> {
            System.out.println("Перевірка адреси гаманця: " + wallet);
            System.out.println("Оплачено за допомогою Bitcoin.");
        };
    }
}
