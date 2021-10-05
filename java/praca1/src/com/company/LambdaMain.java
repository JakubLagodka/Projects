package com.company;

import java.util.Set;
import java.util.TreeSet;
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

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("ja");

        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());

        Supplier<Double> supplier1 = Math::random;
        System.out.println(supplier1.get());

        Predicate<String> stringPredicate = str -> str.isEmpty();
        System.out.println(stringPredicate.test(""));

        Predicate<String> stringPredicate1 = String::isEmpty;
        System.out.println(stringPredicate1.test(""));

        Function<String, Integer> function = str -> str.length();
        System.out.println(function.apply("piooji"));

        Function<String, Integer> function1 = String::length;
        System.out.println(function1.apply("piooji"));

        BiFunction<String, String, Integer> biFunction = (str1, str2) -> str1.length() + str2.length();
        System.out.println(biFunction.apply("kuba", "ola"));

        Runnable runnable = () -> System.out.println("hej!");
        runnable.run();

        Callable<Double> callable = () -> Math.random();
        System.out.println(callable.call());

        Callable<Double> callable1 = Math::random;
        System.out.println(callable1.call());

        BiConsumer<String, String> biConsumer = (str1, str2) -> System.out.println(str1 + ", " + str2);
        biConsumer.accept("czesc", "wszystkim");

        BiPredicate<String, String> biPredicate = (str1, str2) -> str1.isEmpty() && str2.isEmpty();
        System.out.println(biPredicate.test("", ""));

        UnaryOperator<Integer> unaryOperator = (integer) -> ++integer; //post inkrementacja nie dziala!
        System.out.println(unaryOperator.apply(1));

        BinaryOperator<Integer> binaryOperator = (integer, integer2) -> integer + integer2;
        System.out.println(binaryOperator.apply(2, 4));

        BinaryOperator<Integer> binaryOperator1 = Integer::sum;
        System.out.println(binaryOperator1.apply(2, 4));

        Fraction fraction = new Fraction(2, 4);

        System.out.println(fraction);
        System.out.println(fraction.add(new Fraction(1, 2)));
        System.out.println(fraction.subtract(new Fraction(2, 3)));
        System.out.println(fraction.multiply(new Fraction(3, 4)));
        System.out.println(fraction.divide(new Fraction(4, 5)));
        System.out.println(fraction.exponentiate(2));
        System.out.println(fraction.root());
        System.out.println(fraction);
        System.out.println(fraction.decimalNotation());
        System.out.println(fraction.compareTo(new Fraction(1, 2)));
        Set<Fraction> treeSet= new TreeSet<>();
        treeSet.add(fraction);
        treeSet.add(new Fraction(1,4));
        treeSet.add(new Fraction(1,3));
        System.out.println(treeSet);
    }

}
