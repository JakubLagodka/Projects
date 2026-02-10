package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Write a program in Java to find the first non-repeating character in a given string.
//A non-repeating character is one that appears only once in the string and does not repeat later on.
//For example:
//hello -> h
//aabccd -> b
//welcome to java world -> c
//
//Functional Requirements:
//        - The program should take a string as an input.
//- It should find and return the first non-repeating character in the string.
//- If no such character is found, the program should return a message indicating
// that there are no non-repeating characters in the string.
//
//Additional Requirement:
//        - Try to optimize the algorithm to achieve better time complexity.
//        - Try to optimize the algorithm to achieve better space complexity.
public class Main {

    public static void main(String[] args) {
//        System.out.println(findFirstNonReapitingChar("hello"));
    }

    //nie działa
    static String findFirstNonRepeatingCharStream(String string) {
        HashMap<String, Long> noCharHashMap = new HashMap<>();
        noCharHashMap.put("there are no non-repeating characters in the string", 1L);
        return Arrays.stream(string.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue() == 1)
                .findFirst().orElse(noCharHashMap.entrySet().stream().findFirst().get())
                .getKey();
    }

    //działa
    static String findFirstNonRepeatingChar(String string) {
        HashMap<String, Long> noCharHashMap = new HashMap<>();
        noCharHashMap.put("there are no non-repeating characters in the string", 1L);
        Map<String, Long> charsLinkedHasSet = new LinkedHashMap<>();
        for (int i = 0; i < string.length(); i++) {
            charsLinkedHasSet.put(String.valueOf(string.charAt(i)),
                    charsLinkedHasSet.containsKey(String.valueOf(string.charAt(i))) ?
                            charsLinkedHasSet.get(String.valueOf(string.charAt(i))) + 1 : 1);
        }

        return charsLinkedHasSet.entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() == 1)
                .findFirst().orElse(noCharHashMap.entrySet().stream().findFirst().get())
                .getKey();

    }
    //działa
    static String findFirstNonRepeatingCharSplit(String string) {
        HashMap<String, Long> noCharHashMap = new HashMap<>();
        noCharHashMap.put("there are no non-repeating characters in the string", 1L);
        Map<String, Long> charsLinkedHasSet = new LinkedHashMap<>();
        Arrays.stream(string.split("")).forEach(string1 ->
                charsLinkedHasSet.put(String.valueOf(string1),
                        charsLinkedHasSet.containsKey(string1) ?
                                charsLinkedHasSet.get(string1) + 1 : 1));

        return charsLinkedHasSet.entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() == 1)
                .findFirst().orElse(noCharHashMap.entrySet().stream().findFirst().get())
                .getKey();

    }
    static String calculate(String string){
        int index = 0;
        Map<String, Long> collect = new LinkedHashMap<>(); //dla HashMap i TreeMap nie działa najpierw jest a!
        for (int i = 0; i < string.length(); i++){
//            String character = String.valueOf(string.charAt(i));
//            collect.put(character,collect.get(character) == null ? 1 : collect.get(character) + 1);
            collect.merge(String.valueOf(string.charAt(i)),1L,Long::sum);
        }
//        for (Map.Entry<String, Long> stringLongEntry : collect.entrySet()) {
//            if (stringLongEntry.getValue() == 1){
//                return stringLongEntry.getKey();
//            }
//        }
        return collect.entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() == 1)
                .findFirst().orElse(null).getKey();
    }
}