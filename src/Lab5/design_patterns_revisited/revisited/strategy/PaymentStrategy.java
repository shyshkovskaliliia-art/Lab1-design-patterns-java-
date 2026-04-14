package Lab5.design_patterns_revisited.revisited.strategy;

@FunctionalInterface
public interface PaymentStrategy {
    void pay(int amount);
}
