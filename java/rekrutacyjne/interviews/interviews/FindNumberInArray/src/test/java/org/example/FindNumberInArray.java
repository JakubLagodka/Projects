package org.example;

public class FindNumberInArray {
    public int findNumberInArray(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {
            if(array[i] == target|| array[i] > target){
                return i;
            }
        }
        return array.length-1;
    }
}
