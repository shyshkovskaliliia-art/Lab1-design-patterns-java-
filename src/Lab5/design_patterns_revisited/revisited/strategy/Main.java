package Lab5.design_patterns_revisited.revisited.strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProductPrice(100);
        cart.addProductPrice(250);

        cart.checkout(amount ->
                System.out.println("Оплачено " + amount + " грн через Credit Card."));

        cart.checkout(amount -> {
            System.out.println("Авторизація в PayPal...");
            System.out.println("Оплачено " + amount + " грн через PayPal.");
        });

        cart.checkout(amount ->
                System.out.println("Оплачено " + amount + " грн через Bitcoin."));
    }
}
