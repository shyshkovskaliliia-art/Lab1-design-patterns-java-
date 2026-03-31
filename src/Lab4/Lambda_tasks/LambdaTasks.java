package Lab4.Lambda_tasks;

import java.util.*;
import java.util.stream.IntStream;

public class LambdaTasks {

    // task1
    public static List<Integer> task1(List<Integer> num) {
        return num.stream()
                .filter(n -> n % 2 != 0)
                .toList();
    }

    // task2
    public static double task2(List<Double> num) {
        return num.stream()
                .mapToDouble(n -> n)
                .average()
                .orElse(0.0);
    }

    // task3
    public static List<String> task3(List<String> strings) {
        return strings.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();
    }

    // task4
    public static int task4(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .sum();
    }

    // task5
    public static long task5(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;

        return IntStream.rangeClosed(2, n)
                .mapToLong(i -> i)
                .reduce(1L, (a, b) -> a * b);
    }

    // task6
    public static String task6(List<Integer> numbers) {
        long sum = numbers.stream().mapToLong(n -> n).sum();
        long product = numbers.stream().mapToLong(n -> n).reduce(1L, (a, b) -> a * b);

        return "Сума: " + sum + ", Добуток: " + product;
    }

    // task7
    public static List<Integer> task7(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .toList();
    }

    // task8
    public static List<String> task8(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // task9
    public static long task9(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        return Arrays.stream(sentence.split("\\s+"))
                .filter(word -> !word.isEmpty())
                .count();
    }

    // task10
    public static String task10(List<String> strings) {
        return strings.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .findFirst()
                .orElse("Немає непорожніх рядків");
    }

    // task11
    public static boolean task11(List<String> strings) {
        if (strings.isEmpty()) return true;
        return strings.stream()
                .allMatch(s -> s != null && !s.isEmpty() &&
                        Character.isUpperCase(s.charAt(0)));
    }

    // task12.
    public static Optional<Integer> task12(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst();
    }

    // task13
    public static Optional<Integer> task13(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .max(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Double> doubleList = Arrays.asList(1.5, 2.7, 3.9, 4.2, 5.1);
        List<String> stringList = Arrays.asList("Apple", "banana", "Cherry", "date", "Elderberry", "");
        List<String> stringListUpper = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");
        String sentence = "Це речення для тестування підрахунку кількості слів у Java програмі";
        int factorialNum = 5;

        System.out.println("=== Лабораторна 4: Lambda + Stream API ===\n");

        System.out.println("1. Непарні числа: " + task1(intList));
        System.out.println("2. Середнє значення: " + String.format("%.2f", task2(doubleList)));
        System.out.println("3. Відсортовані рядки (алфавіт): " + task3(stringList));
        System.out.println("4. Сума парних чисел: " + task4(intList));
        System.out.println("5. Факторіал " + factorialNum + ": " + task5(factorialNum));
        System.out.println("6. " + task6(intList));
        System.out.println("7. Квадрати чисел: " + task7(intList));
        System.out.println("8. Відсортовані рядки за довжиною: " + task8(stringList));
        System.out.println("9. Кількість слів: " + task9(sentence));
        System.out.println("10. Перший непорожній рядок: " + task10(stringList));
        System.out.println("11. Всі рядки з великої літери? " + task11(stringListUpper));
        System.out.println("12. Друге за величиною число: " + task12(intList).orElse(-1));
        System.out.println("13. Найбільше парне число: " + task13(intList).orElse(-1));
    }
}