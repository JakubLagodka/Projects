package query;
//Given an array of integers arr, return true if and only if it is a valid mountain array.
//
//Recall that arr is a mountain array if and only if:
//
//arr.length >= 3
//There exists some i with 0 < i < arr.length - 1 such that:
//arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

public class Main {
    public static void main( String[] args ) {
        System.out.println(validMountainArray(new int[]{1,2,2,3,2}));
    }
    public static boolean validMountainArray(int[] arr) {
        if(arr.length < 3 || arr[1] <= arr[0] || arr[2] == arr[1]){
            return false;
        }
        int maximum = arr[0];
        int maxIndex = 0;
        for ( int i = 1; i < arr.length; i++ ) {
            if(arr[i] > maximum){
                maximum = arr[i];
                maxIndex = i;
            }
            if(arr[i-1] == arr[i]){
                return false;
            }
        }
        if ( maxIndex==arr.length-1 ){
            return false;
        }
        return true;
    }
}
