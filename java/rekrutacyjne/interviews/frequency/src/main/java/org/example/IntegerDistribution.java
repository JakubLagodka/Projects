package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Write a simple application which, when given a list of integers:
//
//        - Calculates and prints out the mode of the distribution
//- Prints a bar chart showing the frequency of each element. For the sake of simplicity, the bar chart can be horizontal i.e.
// with the number on the y axis, and frequency on the x axis. Although a nice to have, the y axis doesn't have to be ordered.
//
//Consider the time and space complexity of your solution, aiming for one that is O(N) in both cases,
// where N is the size of the input collection.
//
//Initial signature: void analyse(Collection<Integer> values);
//
//Example:
//input: [1,3,3,1,4,3,3]
//
//output:
//mode=3
//        1 | **
//        3 | ****
//        4 | *
//like 1
public class IntegerDistribution {

    public static void analyse(Collection<Integer> values) {
        // Create a map to store element frequencies.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxCount = 0;
        int mode = 0;

        // Count element occurrences in a single pass.
        for (Integer value : values) {
            int count = frequencyMap.getOrDefault(value, 0) + 1;
            frequencyMap.put(value, count);
            if (count > maxCount) {
                maxCount = count;
                mode = value;
            }
        }
        // Print the mode.
        System.out.println("mode=" + mode);

        // Print the horizontal bar chart.
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(STR."\{entry.getKey()} | \{repeat('*', entry.getValue())}");
//            System.out.println(entry.getKey() + " | " + repeat('*', entry.getValue()));
        }
    }

    public static int analyseOperations(int[] nums, int k) {
        Arrays.sort(nums);
        // Create a map to store element frequencies.
//        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxCount = 0;
        int mode = 0;
//
//        // Count element occurrences in a single pass.
//        for (Integer value : nums) {
//            int count = frequencyMap.getOrDefault(value, 0) + 1;
//            frequencyMap.put(value, count);
//            if (count > maxCount) {
//                maxCount = count;
//                mode = value;
//            }
//        }
        int tmp = 0;
        int count = 0;
        int kTmp = k;
//        for (int i = 0; i < frequencyMap.size(); i++) {
//            Integer max = frequencyMap.entrySet().stream().skip(i).findFirst().orElse(null).getKey();
//            Integer maxValue = frequencyMap.entrySet().stream().skip(i).findFirst().orElse(null).getValue();
//            count = 0;
//            kTmp = k;
//            for (Map.Entry<Integer, Integer> integerIntegerEntry : frequencyMap.entrySet()) {
//                tmp = max - integerIntegerEntry.getKey();
//                if(tmp >= 0){
//                    multiplier = integerIntegerEntry.getValue();
//                    kTmp = kTmp - multiplier*tmp;
//                    count = count + multiplier;
//                    if (kTmp < 0){
//                        break;
//                    }
//                }
//            }
//            if(count > maxCount){
//                maxCount = count;
//                if(maxValue > 1){
//                    maxCount++;
//                }
//            }
//        }

        if (nums.length == 1) {
            return 1;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] > nums[i]) {
                mode = nums[i];
                count = 1;
                kTmp = k;
                for (int j = i-1; j >= 0; j--) {
                    tmp = mode - nums[j];
                    if (tmp > 0 ) {

                        kTmp = kTmp - tmp;

                    }
                    if (kTmp < 0) {
                        break;
                    }
                    count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        mode = nums[nums.length-1];
        count = 1;
        kTmp = k;
        for (int j = nums.length-1-1; j >= 0; j--) {
            tmp = mode - nums[j];
            if (tmp > 0 ) {

                kTmp = kTmp - tmp;

            }
            if (kTmp < 0) {
                break;
            }
            count++;
        }
        if (count > maxCount) {
            maxCount = count;
        }

        return maxCount;
    }

    public static void analyse22(Collection<Integer> values) {
        // Create a map to store element frequencies.
        Map<Integer, String> frequencyMap = new HashMap<>();
        int maxCount = 0;
        int mode = 0;

        // Count element occurrences in a single pass.
        for (Integer value : values) {
//            int count = frequencyMap.getOrDefault(value, 0) + 1;
//            frequencyMap.put(value, count);
//            if (count > maxCount) {
//                maxCount = count;
//                mode = value;
//            }
            frequencyMap.put(value, frequencyMap.getOrDefault(value, "") + "*");
        }

        // Print the mode.
        System.out.println("mode=" + mode);

        // Print the horizontal bar chart.
        frequencyMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));

    }

    public static void analyseStream(Collection<Integer> values) {
        // Create a map to store element frequencies.
        Map<Integer, Long> frequencyMap = values
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int mode = frequencyMap.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow(NoSuchElementException::new)
                .getKey();
        // Print the mode.
        System.out.println("mode=" + mode);

        // Print the horizontal bar chart.
        for (Map.Entry<Integer, Long> entry : frequencyMap.entrySet()) {
            System.out.println(STR."\{entry.getKey()} | \{repeat('*', Math.toIntExact(entry.getValue()))}");
//            System.out.println(entry.getKey() + " | " + repeat('*', entry.getValue()));
        }
    }

    public static void analyseStream2(Collection<Integer> values) {
        values.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " | " + "*".repeat(value.intValue())));
    }

    public static void analyse2(Collection<Integer> values) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        values.forEach(value -> occurrences.merge(value, 1, Integer::sum));

        Integer mode = Collections.max(occurrences.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("mode=" + mode);
        occurrences.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(entry -> printBar(entry.getKey(), entry.getValue()));
    }

    private static void printBar(Integer key, Integer length) {
        System.out.println(key + " | " + "*".repeat(Math.max(0, length)));
    }

    private static void analyse3(final Collection<Integer> values) {
        final String collect = values.parallelStream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .parallelStream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .map(entry -> String.format("%d|%s", entry.getKey(), generateStars(entry.getValue())))
                .collect(Collectors.joining("\n"));
        final String[] split = collect.split("\n");
        System.out.println("mode=" + split[split.length - 1].split("\\|")[0]);
        System.out.println(collect);
    }

    private static String generateStars(final long count) {
        return "*".repeat(Math.max(0, (int) count));
    }

    public static void analyseStatistics(Collection<Integer> values) {
        Map<Integer, IntSummaryStatistics> frequencyStats = values
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summarizingInt(Integer::intValue)));
        System.out.println(values.stream().collect(Collectors.summarizingInt(Integer::intValue)));
        for (Map.Entry<Integer, IntSummaryStatistics> entry : frequencyStats.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }

    private static String repeat(char c, int count) {
//        StringBuilder sb = new StringBuilder();
        //        for (int i = 0; i < count; i++) {
//            sb.append(c);
//        }
        return String.valueOf(c).repeat(Math.max(0, count));
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 3, 1, 4, 3, 3};
//        System.out.println(analyseOperations(data,5));
        System.out.println(analyseOperations(new int[]{1,2,4},5));
        System.out.println(analyseOperations(new int[]{1, 4, 8, 13}, 5));
          System.out.println(analyseOperations(new int[]{9922, 9980, 9990, 9922, 9932, 9989, 9929, 9938, 9941, 9966, 9985, 9906, 9964, 9903, 9995, 9963, 10000, 9950, 9939, 9985, 9944, 9960, 9989, 9977, 9901, 9923, 9997, 9971, 9909, 9985, 9979, 9906, 9955, 9988, 9996, 9995, 9901, 9996, 9924, 9967, 9991, 9981, 9914, 9933, 9946, 9928, 9975, 9990, 9968, 9985, 9963, 9927, 9946, 9919, 9931, 9955, 9979, 9943, 9905, 9918, 9962, 9970, 9939, 9901, 9940, 9933, 9917, 9988, 9935, 9941, 9947, 9971, 9901, 9926, 9908, 9969, 9978, 9984, 9952, 9945, 9958, 9958, 9930, 9923, 9950, 9993, 9938, 9976, 9942, 9946, 9990, 9951, 9971, 9980, 9966, 9944, 9976, 9954, 9970, 9984, 9939, 9961, 9996, 9993, 9935, 9949, 9975, 9952, 9998, 9956, 9957, 9949, 9902, 9946, 9979, 9904, 9925, 9948, 9952, 9961, 9948, 9982, 9922, 9958, 9956}, 1911));
//        System.out.println(analyseOperations(new int[]{1, 1, 1, 1, 5, 6, 7, 7}, 9));
        System.out.println(analyseOperations(new int[]{9926, 9960, 10000, 9992, 9917, 9986, 9934, 9985, 9977, 9950, 9922, 9913, 9971, 9978, 9984, 9959, 9934, 9948, 9918, 9916, 9967, 9965, 9985, 9977, 9988, 9983, 9900, 9945, 9913, 9966, 9968, 9986, 9939, 9914, 9980, 9957, 9921, 9927, 9917, 9972, 9974, 9953, 9984, 9912, 9975, 9920, 9966, 9932, 9921, 9904, 9928, 9959, 9993, 9937, 9934, 9974, 9937, 9964, 9922, 9963, 9991, 9930, 9944, 9930, 9982, 9980, 9967, 9904, 9955, 9947, 9924, 9973, 9997, 9950, 9905, 9924, 9990, 9947, 9953, 9924, 9977, 9938, 9951, 9982, 9932, 9926, 9928, 9912, 9917, 9929, 9924, 9921, 9987, 9910, 9927, 9921, 9929, 9937, 9919, 9995, 9949, 9953}, 3044));
        System.out.println(analyseOperations(new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966}, 3056));
       System.out.println(analyseOperations(new int[]{       9968,9934,9996,9928,9934,9906,9971,9980,9931,9970,9928,9973,9930,9992,9930,9920,9927,9951,9939,9915,9963,9955,9955,9955,9933,9926,9987,9912,9942,9961,9988,9966,9906,9992,9938,9941,9987,9917,10000,9919,9945,9953,9994,9913,9983,9967,9996,9962,9982,9946,9924,9982,9910,9930,9990,9903,9987,9977,9927,9922,9970,9978,9925,9950,9988,9980,9991,9997,9920,9910,9957,9938,9928,9944,9995,9905,9937,9946,9953,9909,9979,9961,9986,9979,9996,9912,9906,9968,9926,10000,9922,9943,9982,9917,9920,9952,9908,10000,9914,9979,9932,9918,9996,9923,9929,9997,9901,9955,9976,9959,9995,9948,9994,9996,9939,9977,9977,9901,9939,9953,9902,9926,9993,9926,9906,9914,9911,9901,9912,9990,9922,9911,9907,9901,9998,9941,9950,9985,9935,9928,9909,9929,9963,9997,9977,9997,9938,9933,9925,9907,9976,9921,9957,9931,9925,9979,9935,9990,9910,9938,9947,9969,9989,9976,9900,9910,9967,9951,9984,9979,9916,9978,9961,9986,9945,9976,9980,9921,9975,9999,9922}, 1524));
        //        analyse22(List.of(data));
//        analyseStream(List.of(data));
//        analyseStatistics(List.of(data));
    }
}
//HashMap for Frequencies: We use a HashMap named frequencyMap to store the count of each unique element.
//analyse Function:
//Takes a collection of integers values as input.
//Initializes maxCount and mode to track the most frequent element and its count.
//Iterates through the values using a for-each loop:
//Uses getOrDefault on frequencyMap to retrieve the existing count for the current value (or 0 if absent). Increments the count by 1.
//Updates frequencyMap with the new count.
//If the current count is greater than maxCount:
//Updates maxCount and mode with the new highest frequency and element.
//Prints the mode using System.out.println.
//Iterates through frequencyMap using an enhanced for-each loop over the entrySet().
//Prints the key (element) and a horizontal bar using repeat method.
//repeat Method:
//Takes a character c and a count int as input.
//Creates a StringBuilder and appends the character c count times.
//Returns the string built from repeated characters.
//main Method:
//Creates an array of integers data.
//Converts the array to a list using List.of and calls analyse with this list.
//Time and Space Complexity:
//
//Time Complexity: O(N). The loop iterates through the input collection once, and the inner loop for printing the chart iterates through the hash map (which has size proportional to the unique elements). Both loops are linear in the size of the input (N).
//Space Complexity: O(N). The HashMap stores unique elements and their frequencies, which scales linearly with the number of unique elements in the list. In the worst case (all elements are unique), the space complexity would be O(N).
//This code achieves the desired functionalities while maintaining a time and space complexity of O(N).