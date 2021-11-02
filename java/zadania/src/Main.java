import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Janusz", "Kowalski", LocalDate.of(1996, 8, 8), 4.5));
        studentList.add(new Student("Jakub", "Lagodka", LocalDate.of(1996, 8, 7), 4.5));
        studentList.add(new Student("Jan", "Kowalski", LocalDate.of(1997, 8, 7), 4.5));
        studentList.add(new Student("Jakub", "Nowak", LocalDate.of(1996, 8, 6), 4.6));

        System.out.println(Student.findSecondTheBestStudent(studentList));

        System.out.println(Arrays.toString(findPairs(Arrays.asList(2, 3, 4, 4, 6), 8)));
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

    static List<Integer>[] findPairs(List<Integer> integers, Integer sum) {
        //zapytać na konsultacjach o to!
        //List<Integer>[] returnedPairs = new ArrayList<Integer>[]{(ArrayList<Integer>) Arrays.asList(2, 3, 4, 4, 6)};

        List<Integer>[] pairs = new ArrayList[100];
        List<Integer>[] returnedPairs;
        int indexOfPairs = 0;
        int indexOfIntegers = 0;
        for (Integer integer : integers) {
            for (int i = indexOfIntegers + 1; i < integers.size(); i++) {
                if (integer + integers.get(i) == sum) {
                    pairs[indexOfPairs] = new ArrayList<>();
                    pairs[indexOfPairs].add(integer);
                    pairs[indexOfPairs].add(integers.get(i));
                    indexOfPairs++;

                }
            }
            indexOfIntegers++;
        }
        returnedPairs = new ArrayList[indexOfPairs];

        for (int i = 0; i < indexOfPairs; i++) {
            returnedPairs[i] = new ArrayList<>();
            returnedPairs[i].add(pairs[i].get(0));
            returnedPairs[i].add(pairs[i].get(1));
        }
        return returnedPairs;
    }
}
