package Lab4.Lambda_tasks;

import java.util.*;
import java.util.stream.Collectors*;
import java.util.stream.IntStream*;

public class LambdaTasks {

    //task 1
    public static List<Integer> task1(List<Integer> num){
        return num.stream()
                .filter(n -> n%2 !=0)
                .collect(Collectors.toUnmodifiableList());
    }

    //task 2
    public static double task2(List<Double> num){
        return num.stream()
                .mapToDouble(n-> n)
                .average()
                .orElse(0.0);

    }

    // task 3
    public static List<String> task3 (List<String> strings){
        return strings.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());

    }

    //task4
    public static int task4(List<Integer> numbers){
        return numbers.stream()
                .filter(n-> n%2 == 0)
                .mapToInt(n->n)
                .sum()
    }

    //task5
    public static long task5(int n){
        if (n<0) return 0;
        return IntStream.rangeClosed(1,n)
                .reduce(1,(a,b)-> a*b);
    }

    //task6
    public static String task6(List<Integer> numbers){
        long sum = numbers.stream()
                .mapToLong(n-> n)
                .sum();
        long product = numbers.stream()
                .reduce(1L,(a,b)-> a*b);
        return "Sum:" + sum +",Product: " + product;
    }

    //task7
    public static List<Integer> task7 (List<Integer> numbers){
        return numbers.stream()
                .map(n-> n*n)
                .collect(Collectors.toList());
    }



}
