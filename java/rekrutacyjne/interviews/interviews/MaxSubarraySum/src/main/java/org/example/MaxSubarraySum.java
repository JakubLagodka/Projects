package org.example;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class MaxSubarraySum {
    public static int findMaxSubarraySum(int[] arr) {
        int size = arr.length;
        if (size != 0) {
            int maxSum = arr[0];
            for (int j = 0; j < size; j++) {
                int partialSum = arr[j];
                if (j == size - 1 || partialSum >= 0 && arr[j + 1] < 0) {
                    for (int k = 0; k < j; k++) {
                        if (partialSum > maxSum) {
                            maxSum = partialSum;
                        }
                        partialSum += arr[k];
                    }
                }
                if (partialSum > maxSum) {
                    maxSum = partialSum;
                }
            }
            return maxSum;
        }
        return 0;
    }

    // w peek nie przypisują się wartości!
    public static int findMaxSubarraySumStream(int[] arr) {
        final int[] maxSum = {arr.length == 0 ? 0 : arr[0]};
        final int[] tmpSum = {0};
        final int[] index = {0};
        Arrays.stream(arr).forEach(value -> {
            tmpSum[0] = value;
            index[0]++;
            Arrays.stream(arr).skip(index[0]).forEach(value1 -> {
                tmpSum[0] += value1;
                if (tmpSum[0] > maxSum[0]) {
                    maxSum[0] = tmpSum[0];
                }
            });
        });
        return maxSum[0];
    }

    public static int findMaxSubarraySumStreamIterator(int[] arr) {
        final int[] maxSum = {arr.length == 0 ? 0 : arr[0]};
        final int[] tmpSum = {0};
        final int[] index = {0};
        Arrays.stream(arr).forEach(value -> {
            tmpSum[0] = value;
            index[0]++;
            Arrays.stream(arr).skip(index[0]).iterator().forEachRemaining((IntConsumer) value1 -> {
                tmpSum[0] += value1;
                if (tmpSum[0] > maxSum[0]) {
                    maxSum[0] = tmpSum[0];
                }
            });
        });
        return maxSum[0];
    }
}