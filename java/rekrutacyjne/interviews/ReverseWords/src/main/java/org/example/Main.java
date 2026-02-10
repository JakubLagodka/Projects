package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        String result = "";
        for (int i = split.length-1; i >= 0; i--) {
            if (!split[i].isEmpty()) {
                result += split[i];
                if (i > 0) {
                    result += " ";
                }

            }
        }
        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
    }
}