package Lab5.design_patterns_revisited.revisited.execute_around;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Execute Around Pattern ===");

        Resource.use(resource -> {
            resource.doWork("Платіж $100");
            resource.doWork("Логування транзакції");
        });
    }
}
