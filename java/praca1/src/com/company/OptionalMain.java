package com.company;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class OptionalMain {
    public static void main(String[] args) throws Exception {
        //wywołać of i sout, przetestowac metody
        MyOptional<String> myOptional = MyOptional.of("a");
        myOptional.ifPresent(System.out::println);
        MyOptional.empty();
        System.out.println(myOptional.get());

        Predicate<String> predicate = String::isEmpty;
        System.out.println(myOptional.filter(predicate));

        Function<String, Integer> function = String::length;
        System.out.println(myOptional.map(function));
        myOptional.ifPresentOrElse(System.out::println, () -> System.out.println("hej"));
        System.out.println(myOptional.isEmpty());
        System.out.println(myOptional.isPresent());
        System.out.println(myOptional.orElse("null value"));
        System.out.println(myOptional.orElseGet(String::new));
        System.out.println(myOptional.orElseThrow(Exception::new));

        MyOptional<String> emptyOptional = MyOptional.empty();
        emptyOptional.ifPresentOrElse(System.out::println, () -> System.out.println("hej"));
        System.out.println(emptyOptional.orElse("null value"));
        System.out.println(emptyOptional.orElseGet(String::new));
        System.out.println(emptyOptional.orElseThrow(Exception::new));
    }
}
