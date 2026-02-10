package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountElementsWithMaxFreqency {

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxCount = 0;
        int numberOfElementsWithMaxFreq = 0;

        for (Integer value : nums) {
            int count = frequencyMap.getOrDefault(value, 0) + 1;
            frequencyMap.put(value, count);
            if (count > maxCount) {
                maxCount = count;
                numberOfElementsWithMaxFreq = count;
            } else if (count == maxCount){
                numberOfElementsWithMaxFreq += count;
            }
        }
        return numberOfElementsWithMaxFreq;
    }
        public static void main(String[] args) {
            int[] data = {1,2,2,3,1,4};
            System.out.println(maxFrequencyElements(data));
        }
}
