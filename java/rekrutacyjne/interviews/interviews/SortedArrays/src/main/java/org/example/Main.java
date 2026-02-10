package org.example;

import java.util.Arrays;

public class Main {
    public static int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] result = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        while (i < n1) {
            result[k++] = nums1[i++];
        }

        while (j < n2) {
            result[k++] = nums2[j++];
        }
        return result;
    }
    public static int[] sortArray(int[] nums) {
        int lennNums = nums.length;
        if(lennNums < 2){
            return nums;
        }
        int i = 0, j = 0, k = 0;
        int[] n1 = new int[lennNums/2];
        int[] n2;
        if(lennNums%2 == 1){
            n2 =  new int[lennNums/2+1];
            for(i=0;i<=lennNums/2;i++){
                n2[i] = nums[i];
            }
        }
        else{
            n2= new int[lennNums/2];
            for(i=0;i<lennNums/2;i++){
                n2[i] = nums[i];
            }
        }
        for(j=0;j<lennNums/2;j++){
            n1[j] = nums[i];
            i++;
        }
        for(j=1;j<=lennNums/2;j++){
        for(i=1;i<=lennNums/2;i++){
            if(i < n1.length && n1[i] <n1[i-1]){
                k = n1[i-1];
                n1[i-1] = n1[i];
                n1[i] = k;
            }
            if(i < n2.length &&n2[i] <n2[i-1]){
                k = n2[i-1];
                n2[i-1] = n2[i];
                n2[i] = k;
            }
        }}
        int length1 = n1.length;
        int length2 = n2.length;
        int[] result = new int[length1 + length2];
        i = 0;
        j = 0;
        k = 0;
        while (i < length1 && j < length2) {
            if (n1[i] <= n2[j]) {
                result[k++] = n1[i++];
            } else {
                result[k++] = n2[j++];
            }
        }

        while (i < length1) {
            result[k++] = n1[i++];
        }

        while (j < length2) {
            result[k++] = n2[j++];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2, 4};
        int[] result = merge(arr1, arr2);
        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(sortArray(arr1)));
//        System.out.println(Arrays.toString(sortArray(new int[]{-4,0,7,4,9,-5,-1,0,-7,-1})));
        System.out.println(Arrays.toString(sortArray(new int[]{5,2,6})));
        int[] arr3 = {5, 6, 10};
        int[] arr4 = {7, 8, 9};
        result = merge(arr3, arr4);
        System.out.println(Arrays.toString(result));
    }
}