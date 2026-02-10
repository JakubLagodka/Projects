package org.example;
//Write a program in Java to find the first non-repeating character in a given string.
// A non-repeating character is one that appears only once in the string and does not repeat later on.
//For example:
//hello -> h
//aabccd -> b
//welcome to java world -> c
//
//Functional Requirements:
//The program should take a string as an input.
//It should find and return the first non-repeating character in the string.
//If no such character is found, the program should return a message indicating that there are no non-repeating characters
// in the string.
//
//Additional Requirement:
//Try to optimize the algorithm to achieve better time complexity.
//Try to optimize the algorithm to achieve better space complexity.

import java.util.*;

public class Main {

    public static char findFirstNonRepeatingCharacter(String input) {
        if (input == null || input.isEmpty()) {
            return Character.UNASSIGNED;
        }
        if (input.length() == 1) {
            return input.charAt(0);
        }

        char[] charArray = input.toCharArray();
        List<Character> nonRepeatingChars = new ArrayList<>();
        List<Character> repeatingChars = new ArrayList<>();

        for (char c : charArray) {
            if (!nonRepeatingChars.contains(c)) {
                if (!repeatingChars.contains(c)) {
                    nonRepeatingChars.add(c);
                }
            } else {
                nonRepeatingChars.remove(Character.valueOf(c));
                repeatingChars.add(c);
            }
        }

        if (nonRepeatingChars.isEmpty()) {
            return Character.UNASSIGNED;
        }
        return nonRepeatingChars.getFirst();
    }

    public static int solutionFromLeet(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] charArray = s.toCharArray();
        List<Character> nonRepeatingChars = new ArrayList<>();
        List<Character> repeatingChars = new ArrayList<>();
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < charArray.length; i++) {
            if (!nonRepeatingChars.contains(charArray[i])) {
                if (!repeatingChars.contains(charArray[i])) {
                    nonRepeatingChars.add(charArray[i]);
                    currentLength++;
                } else if (currentLength > maxLength) {
                    maxLength = currentLength;
                    currentLength = 1;
                }
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    currentLength = 1;
                }
                nonRepeatingChars.remove(Character.valueOf(charArray[i]));
                repeatingChars.add(charArray[i]);
            }
        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
        return maxLength;
    }

    public static int solutionFromLeet2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] charArray = s.toCharArray();
        List<Character> nonRepeatingChars = new ArrayList<>();
        List<Character> repeatingChars = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        HashMap<Character, Integer> noCharHashMap = new HashMap<>();
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < charArray.length; i++) {
            if (!nonRepeatingChars.contains(charArray[i])) {
                nonRepeatingChars.add(charArray[i]);
                currentLength++;
                noCharHashMap.put(charArray[i], i);
            } else {
                if (i - noCharHashMap.get(charArray[i]) > currentLength) {
                    currentLength++;
                    noCharHashMap.put(charArray[i], i);
                } else if (!noCharHashMap.containsKey(charArray[i])) {
// currentLength = Math.min(i-nonRepeatingChars.indexOf(charArray[i]),currentLength+1);
//  repeatingChars.add(charArray[i]);
//  index.add(i);
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                    noCharHashMap.put(charArray[i], i);
                    currentLength = currentLength - nonRepeatingChars.indexOf(charArray[i]);
                } else {
// currentLength = nonRepeatingChars.indexOf(charArray[i]);
//  currentLength = currentLength - repeatingChars.indexOf(charArray[i]);
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                    currentLength = i - noCharHashMap.get(charArray[i]);
                    noCharHashMap.put(charArray[i], i);
                }
            }
        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
        return maxLength;
    }

    public static int solutionFromLeet2b(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] charArray = s.toCharArray();
        List<Character> nonRepeatingChars = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        int maxLength = 0;
        int currentLength = 0;
        int startOfSequence = 0;

        for (int i = 0; i < charArray.length; i++) {
            if (!nonRepeatingChars.contains(charArray[i])) {
                nonRepeatingChars.add(charArray[i]);
                indexes.add(i);
                currentLength++;
            } else {
                if (i - startOfSequence > currentLength) {
                    currentLength++;
                }
                int i1 = indexes.get(nonRepeatingChars.indexOf(charArray[i])) + 1;
                if(i1 > startOfSequence){
                    startOfSequence = i1;
                }
                currentLength = i - startOfSequence+1;
                indexes.set(nonRepeatingChars.indexOf(charArray[i]), i);
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }

    public static String errorHandling(Character c) {
        if (c == 0) {
            return "In the given input there is no non repeating characters!";
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        System.out.println(errorHandling(findFirstNonRepeatingCharacter("helloa")));
        System.out.println(errorHandling(findFirstNonRepeatingCharacter("aabccd")));
        System.out.println(errorHandling(findFirstNonRepeatingCharacter("welcome to java world")));
        System.out.println(errorHandling(findFirstNonRepeatingCharacter("  ll")));
        System.out.println(solutionFromLeet2("aabaab!bb"));
        System.out.println(solutionFromLeet2("bbbbb"));
        System.out.println(solutionFromLeet2("pwwkew"));
        System.out.println(solutionFromLeet2("bpfbhmipx"));
        System.out.println(solutionFromLeet2b("aabaab!bb"));
        System.out.println(solutionFromLeet2b("bbbbb"));
        System.out.println(solutionFromLeet2b("pwwkew"));
        System.out.println(solutionFromLeet2b("bpfbhmipx"));
    }

    //        longMap = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Map.Entry<String, Long> filtered = longMap.entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue().equals(1L)).findFirst().orElse(null);
//        if(filtered != null){
//            return filtered.getKey();
//        }
//        for (char c : charArray) {
//            longMap.put(String.valueOf(c), longMap.getOrDefault(String.valueOf(c),0L)+1);
//        }
//        Map.Entry<String, Long> stringLongEntry1 = longMap.entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue().equals(1L)).findFirst().orElse(null);
    //        for (Map.Entry<String, Long> stringLongEntry : longMap.entrySet()) {
//            if(stringLongEntry.getValue().equals(1L)){
//                return stringLongEntry.getKey();
//            }
//        }
    // return nonRepeatingChars.isEmpty() ? "In the given input there is no non repeating characters!" : String.valueOf(nonRepeatingChars.getFirst());
    Map<String, Long> longMap = new LinkedHashMap<>();
}