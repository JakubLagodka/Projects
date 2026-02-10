package org.example;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Pyramid {
    public static final long INT = 10000000000L;
    public static final long MAX = INT - INT / 100 - INT / 500;
    static boolean print = true;
    static String last = "";
    static String numberString = "";
    public static void main(String[] args) {

        for (Long number = 0L; number < MAX; number++) {
            if (number.toString().length() > numberString.length()) {
                print = true;
            }
            numberString = number.toString();
            Set<String> digitSet = Arrays.stream(number.toString().split("")).collect(Collectors.toSet());
            if (print && digitSet.size() == numberString.length()) {
                System.out.println(number);
                print = false;
                number = number * 10;
            }
        }
        last = String.valueOf(INT);
        for (Long number = MAX; number > 0L; number--) {
            numberString = number.toString();
            Set<String> digitSet = Arrays.stream(number.toString().split("")).collect(Collectors.toSet());
            if (digitSet.size() == numberString.length() && numberString.length() < last.length()) {
                System.out.println(numberString);
                number /= 10;
                number++;
                last = numberString;
            }
        }
    }
}
