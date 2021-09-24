package com.company;

import java.util.function.*;

public class LambdaMain {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("kuba");
        Consumer<String> consumer1 = str -> System.out.println(str);
        consumer1.accept("ja");

        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());

        Predicate<String> stringPredicate = str -> str.isEmpty();
        System.out.println(stringPredicate.test(""));

        Function<String,Integer> function = str -> str.length();
        System.out.println(function.apply("piooji"));

        BiFunction<String,String,Integer> biFunction = (str1, str2) -> str1.length() + str2.length();
        System.out.println(biFunction.apply("kuba", "ola"));
    }

}
