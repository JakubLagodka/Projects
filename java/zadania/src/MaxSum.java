import java.util.List;
import java.util.Arrays;

public class MaxSum {
    public static int findMaxSum(List<Integer> list) {
        int sum = 0;
        int max = list.get(0);
        int maxI = 0;
        for (int i = 0; i < list.size(); i++) {
            //max = list.get(i);
            if (list.get(i) > max) {
                max = list.get(i);
                maxI = i;
            }

        }
        for (int i = 0; i < list.size(); i++) {
            if (i == maxI)
                continue;
            Integer integerJ = list.get(i);
            int tempSum = integerJ + max;
            if (tempSum > sum)
                sum = tempSum;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        // Should return 20, since 9 and 11 are the largest elements
        // and their sum is 20
        System.out.println(findMaxSum(list));
    }
}