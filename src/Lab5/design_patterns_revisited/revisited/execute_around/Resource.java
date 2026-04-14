package Lab5.design_patterns_revisited.revisited.execute_around;

import java.util.function.Consumer;

public class Resource {
    private boolean open = false;
    private Resource() {}

    private void open() {
        open = true;
        System.out.println("Ресурс відкрито");
    }

    private void close() {
        open = false;
        System.out.println("Ресурс закрито");
    }

    public void doWork(String data) {
        if (!open) {
            throw new IllegalStateException("Ресурс не відкрито!");
        }
        System.out.println("⚙Обробка: " + data);
    }

    public static void use(Consumer<Resource> block) {
        Resource resource = new Resource();
        resource.open();
        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
    }
}
