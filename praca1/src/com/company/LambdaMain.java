package com.company;

import java.util.concurrent.Callable;
import java.util.function.*;

public class LambdaMain {
    public static void main(String[] args) throws Exception {
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

        Runnable runnable = () -> System.out.println("hej!");
        runnable.run();

        Callable<Double> callable = () -> Math.random();
        System.out.println(callable.call());

        BiConsumer<String,String> biConsumer;

        BiPredicate<String,String> biPredicate;

        UnaryOperator<String> unaryOperator;

        BinaryOperator<String> binaryOperator;
    }

}
