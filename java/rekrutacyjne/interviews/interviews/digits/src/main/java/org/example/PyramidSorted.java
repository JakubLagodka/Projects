package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PyramidSorted {
    public static final long INT = 1000000000L;
    public static final long MAX = INT - INT / 100 - INT / 500;
    static boolean print = true;
    static String numberString = "";
    public static void main(String[] args) {

        for (Long number = 0L; number < MAX; number++) {
            if (number.toString().length() > numberString.length()) {
                print = true;
            }
            numberString = number.toString();
            Set<String> digitSet = Arrays.stream(number.toString().split("")).collect(Collectors.toSet());

//            if (print && digitSet.size() == numberString.length() && digitSet.stream().collect(Collectors.joining()).equals(numberString)) {
//                System.out.println(number);
//                print = false;
//                number *= 10;
//            }
            if (print && digitSet.size() == numberString.length() && String.join("", digitSet).equals(numberString)) {
                System.out.println(number);
                print = false;
                number *= 10;
            }
        }
    }
}
