package java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaClass {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello";
        System.out.println(supplier.get());

        Predicate<String> predicate = s -> s.equals("Hello");
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");
        list.stream().filter(predicate).forEach(System.out::println);

        Function<String, Integer> function = s -> s.length();
        System.out.println(function.apply("Hello")); // 5

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(1, 2)); //3

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sử dụng reduce với BiFunction
        int sumReduce = numbers.stream()
                .reduce(0, (subtotal, number) -> subtotal + number);

        System.out.println(sumReduce); // Output: 15
    }
}
