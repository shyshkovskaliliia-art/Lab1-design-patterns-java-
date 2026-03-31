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


}
