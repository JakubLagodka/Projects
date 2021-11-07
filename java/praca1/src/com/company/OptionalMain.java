package com.company;

import java.util.function.Consumer;

public class OptionalMain {
    public static void main(String[] args) {
        //wywołać of i sout, przetestowac metody
        MyOptional<String> myOptional = MyOptional.of("a");
        myOptional.ifPresent(System.out::println);
        MyOptional.empty();
    }
}
