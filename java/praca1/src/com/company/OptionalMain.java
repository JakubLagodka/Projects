package com.company;

import java.util.function.Consumer;

public class OptionalMain {
    public static void main(String[] args) {
        //wywołać of i sout, przetestowac metody
        MyOptional<String> myOptional = MyOptional.of("a");
        myOptional.ifPresent(System.out::println);
        MyOptional.empty();
        System.out.println(myOptional.get());
        //myOptional.filter()
        //myOptional.map();
        //myOptional.ifPresentOrElse();
        System.out.println(myOptional.isEmpty());
        System.out.println(myOptional.isPresent());
//        myOptional.orElse();
//        myOptional.orElseGet();
//        myOptional.orElseThrow();
    }
}
