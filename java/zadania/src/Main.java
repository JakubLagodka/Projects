import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();
        strings.add("sa");
        strings.add("kuba");
        strings.add("ahgdihgal");
        strings.add("hel");
        strings.add("cyc");

        System.out.println(containsAorC(strings));

        //findArray([4,3,3,7,8], [3,7]) >> 2, findArray([1,2,5], [1]) >> 0, findArray([7,8,9], [8,9,10]) >> -1,
        // findArray([0,3,7,4,3,3,7,8], [3,7]) >> 1
        // Integer tab = [4,3,3,7,8]; // error!
        System.out.println(findArray(new int[]{4, 3, 3, 7, 8}, new int[]{3, 7}));
        System.out.println(findArray(new int[]{1, 2, 5}, new int[]{1}));
        System.out.println(findArray(new int[]{7, 8, 9}, new int[]{8, 9, 10}));
        System.out.println(findArray(new int[]{0, 3, 7, 4, 3, 3, 7, 8}, new int[]{3, 7}));
    }

    static List<String> containsAorC(List<String> strings) {
        List<String> foundStrings = new ArrayList<>();

        for (String string : strings) {
            if (string.contains("a") || string.contains("c"))
                foundStrings.add(string);
        }
        return foundStrings;
    }

    static int findArray(int[] array, int[] subArray) {
        if (subArray.length > array.length)
            return -1;
        for (int i = 0; i <= array.length - subArray.length; i++) {
            if (array[i] == subArray[0]) {
                int j = i;
                do {
                    if (array[j] != subArray[j - i])
                        break;
                    j++;
                } while (j - i < subArray.length);
                if (j - i == subArray.length) {
                    return i;
                }
            }
        }
        return -1;
    }
}
