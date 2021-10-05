package com.company;

import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .filter(i -> {
                    System.out.println("filter " + i);
                    return i % 2 == 0;
                }).map(i -> {
                    System.out.println("map " + i);
                    return i * 2;
                })
                .forEach(System.out::println);
//        Stream<Integer> stream = Stream.of(1,2,3);
//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);
        System.out.println(Stream.of(1,2,3)
                .findFirst());

        System.out.println(Stream.of(1,2,3)
                .findAny());

        System.out.println(Stream.of(1,2,3)
                .parallel()
                .findAny());
    }
}
