import java.util.List;

//You are given an integer array height of length n.
// There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.
// Example 1: Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 Explanation:
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
// In this case, the max area of water (blue section) the container can contain is 49.
// Example 2: Input: height = [1,1] Output: 1
//Adam need to find the biggest surface are that 2 numbers from array can form. numbers represent height.
// distance between numbers matter. because we assume that this object will contain liquid
// then we must assume that tha surface area is formed with min  height 2 numbers represent
public class Main {
    private static List<Integer> list = List.of(1,8,6,2,5,4,8,3,7);

    public static void main(String[] args) {
        int calculate = calculateField(list);
        System.out.println(calculate);
    }

    public static int calculateField(List<Integer> list) {
        int max = 0;
        for(int i = 0; list.size() > i; i++) {
            int heightA = list.get(i);
            for (int j = 0; list.size() > j; j++) {
                int heightB = list.get(j);
                int wight = j - i;
                int height = Math.min(heightA, heightB);
                int size = height * wight;
                if (max < size) {
                    max = size;
                }
            }
        }
        return max;
    }

    public static int calculateField2(List<Integer> list) {
        int max = 0;
        for(int i = 0; list.size() > i; i++) {

            for (int j = i + 1; list.size() > j; j++) {
                int wight = j - i;
                int height = Math.min(list.get(i), list.get(j));
                int size = height * wight;
                if (max < size) {
                    max = size;
                }
            }
        }
        return max;
    }
}