package org.example;

import java.util.ArrayList;
import java.util.List;

//Given an array of strings words and a character separator, split each string in words by separator.
public class Main {
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> returned = new ArrayList<>();
        for (String word : words) {
            String[] split = word.split("\\" + String.valueOf(separator));
            for (String string : split) {
                returned.add(string);
            }

        }
        return returned;
    }
    public static void main(String[] args) {
        System.out.println(splitWordsBySeparator(List.of("one.two.three","four.five","six"),'.'));
        System.out.println(splitWordsBySeparator(List.of("one two three","four five","six"),' '));
    }
}