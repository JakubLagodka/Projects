package org.example;

import java.util.Arrays;

public class Main {
    public static void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int[] tmp = Arrays.copyOf(nums, nums.length);
        int index = -k;
        while (index<0) {
            index += nums.length;
        }
        for (int i1 = 0; i1 < nums.length; i1++) {
            nums[i1] = tmp[index];
            index++;
            if (index == nums.length) {
                index = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2}, 1);
        rotate(new int[]{1, 2, 3}, 1);
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate(new int[]{-1, -100, 3, 99}, 2);
    }

    public static boolean isRotation(String in1, String in2) {

        return (in1 + in1).contains(in2) && in1.length() == in2.length();

    }

    public static boolean isRotationCaseInsensitive(String s1, String s2) {
        return (s1 + s1).toLowerCase().contains(s2.toLowerCase()) && s1.length() == s2.length();
    }
}