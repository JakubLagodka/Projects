package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        List<Integer> integerList = new ArrayList<>();
        for (int i : arr2) {
            for (long l = 0; l < Arrays.stream(arr1).filter(value -> value == i).count(); l++) {
                integerList.add(i);
            }
        }
        int[] array = Arrays.stream(arr1).filter(value -> Arrays.stream(arr2).noneMatch(value1 -> value == value1)).toArray();
        int[] ints = integerList.stream().mapToInt(Integer::intValue).toArray();
        int[] result = Arrays.copyOf(ints, array.length + ints.length);
        System.arraycopy(array, 0, result, ints.length, array.length);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}