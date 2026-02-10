package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//Your algorithm should run in O(n) complexity.
//
//Example:
//
//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
public class Main {
    public static void main(@NotNull final String[] args) {
        System.out.println(longestConsecutiveSubsequencePriorityQueue2(new int[]{1, 2, 4, 5, 6, 7}));
        System.out.println(longestConsecutiveSubsequencePriorityQueue2(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutiveSubsequencePriorityQueue2(new int[]{100, 3, 200, 1, 3, 2}));
        System.out.println(longestConsecutiveSubsequenceUnsorted(new int[]{1, 2, 4, 5, 6, 7}));
    }

    private static int longestConsecutiveSubsequencePriorityQueue(final int[] array) {
        final PriorityQueue<Integer> integers = new PriorityQueue<>();
        for (final int i : array) {
            integers.add(i);
        }
        final List<Integer> results = new ArrayList<>();
        int count = 0;
        Integer last = null;
        while (!integers.isEmpty()) {
            final Integer removed = integers.remove();
            if (last == null) {
                results.add(1);
            } else if (last + 1 == removed) {
                results.set(count, results.get(count) + 1);
            } else {
                results.add(1);
                count++;
            }
            last = removed;
        }
        return results.stream().max(Integer::compare).orElse(-1);
    }
    private static int longestConsecutiveSubsequencePriorityQueue2(final int[] array) {
        final PriorityQueue<Integer> integers = new PriorityQueue<>();
        for (final int i : array) {
            integers.add(i);
        }
        final List<Integer> results = new ArrayList<>();
        Integer last = 0;
        int currentResult = 1;
        int maxResult = 1;
        while (!integers.isEmpty()) {
            final Integer removed = integers.remove();
            if (last == 0) {
                last = 1;
            } else if (last + 1 == removed) {
                currentResult++;
                if(currentResult>maxResult){
                    maxResult=currentResult;
                }
            } else {
                currentResult=1;
            }
            last = removed;
        }
        return maxResult;
    }
    private static int longestConsecutiveSubsequenceUnsorted(final int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        Arrays.sort(array);
        int longestSubsequence = 1;
        int currentSubsequence = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] == 1) {
                currentSubsequence++;
                if (currentSubsequence > longestSubsequence) {
                    longestSubsequence = currentSubsequence;
                }
            } else {
                currentSubsequence = 1;
            }
        }
        return longestSubsequence;
    }
    private static int longestConsecutiveSubsequence(final int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        int longestSubsequence = 1;
        int currentSubsequence = 1;
        Set<Integer> integerSet = new TreeSet<>();
        for (int i : array) {
            integerSet.add(i);
        }
        for (int i = 1; i < integerSet.size(); i++) {
            if (integerSet.stream().skip(i).findFirst().get() - integerSet.stream().skip(i-1).findFirst().get() == 1) {
                currentSubsequence++;
                if (currentSubsequence > longestSubsequence) {
                    longestSubsequence = currentSubsequence;
                }
            } else {
                currentSubsequence = 1;
            }
        }
        return longestSubsequence;
    }
}
