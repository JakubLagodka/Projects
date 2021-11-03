import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
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
        studentList.add(new Student("Jakub", "Lagodka", LocalDate.of(1996, 8, 7), 4.6));
        studentList.add(new Student("Jan", "Kowalski", LocalDate.of(1997, 8, 7), 4.5));
        studentList.add(new Student("Jakub", "Nowak", LocalDate.of(1996, 8, 6), 4.6));

        System.out.println(Student.findSecondTheBestStudent(studentList));

        System.out.println(Arrays.toString(findPairs(Arrays.asList(2, 3, 4, 4, 6), 8)));

        System.out.println(findDuplicates(Arrays.asList(1, 2, 4, 5, 2, 4, 5, 8, 9, 4), 2));

        List<String[]> apply = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input.txt"))
                .map(line -> line.split(" "))
                .filter(line -> line[0].equals("apply"))
                .collect(Collectors.toList());

        double result = Double.parseDouble(apply.get(0)[1]);
        List<String[]> operations = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input.txt"))
                .map(line -> line.split(" "))
                .filter(line -> !line[0].equals("apply"))
                .collect(Collectors.toList());

        for (String[] operation : operations) {
            result = MathematicalOperation.findOperationByName(operation[0]).calculate(result, Double.parseDouble(operation[1]));
        }

        System.out.println(result);

        apply = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input2.txt"))
                .map(line -> line.split(" "))
                .filter(line -> line[0].equals("apply"))
                .collect(Collectors.toList());

        result = Double.parseDouble(apply.get(0)[1]);
        operations = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input2.txt"))
                .map(line -> line.split(" "))
                .filter(line -> !line[0].equals("apply"))
                .collect(Collectors.toList());

        for (String[] operation : operations) {
            result = MathematicalOperation.findOperationByName(operation[0]).calculate(result, Double.parseDouble(operation[1]));
        }

        System.out.println(result);

        apply = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input3.txt"))
                .map(line -> line.split(" "))
                .filter(line -> line[0].equals("apply"))
                .collect(Collectors.toList());

        result = Double.parseDouble(apply.get(0)[1]);
        operations = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input3.txt"))
                .map(line -> line.split(" "))
                .filter(line -> !line[0].equals("apply"))
                .collect(Collectors.toList());

        for (String[] operation : operations) {
            result = MathematicalOperation.findOperationByName(operation[0]).calculate(result, Double.parseDouble(operation[1]));
        }

        System.out.println(result);

        List<String[]> products = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\vat.txt"))
                .map(line -> line.split(" "))
                .collect(Collectors.toList());

        double netto8 = 0.0;
        double brutto8 = 0.0;
        double netto23 = 0.0;
        double brutto23 = 0.0;
        double brutto0 = 0.0;
        double tax8 = 0.0;
        double tax23 = 0.0;
        for (String[] product : products) {
            if (Integer.parseInt(product[2]) == 0) {
                brutto0 += Double.parseDouble(product[1]);
            } else if (Integer.parseInt(product[2]) == 8) {
                double value = Double.parseDouble(product[1]);
                brutto8 += value;
                double netto = value / 1.08 * 100;
                netto = Math.round(netto);
                netto /= 100;
                netto8 += netto;
                tax8 += value - netto;
            } else if (Integer.parseInt(product[2]) == 23) {
                double value = Double.parseDouble(product[1]);
                brutto23 += value;
                double netto = value / 1.23 * 100;
                netto = Math.round(netto);
                netto /= 100;
                netto23 += netto;
                tax23 += value - netto;
            } else throw new IOException();
        }

        List<Tax> taxes = new ArrayList<>();
        taxes.add(new Tax("0 procent", brutto0, brutto0, 0.0));
        taxes.add(new Tax("8 procent", brutto8, netto8, tax8));
        taxes.add(new Tax("23 procent", brutto23, netto23, tax23));
        taxes.add(new Tax("suma", brutto0 + brutto8 + brutto23, brutto0 + netto8 + netto23, tax8 + tax23));

        System.out.println(taxes);

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

    static List<Integer> findDuplicates(List<Integer> integers, Integer numberOfDuplicates) {
        List<Integer> returnedList = new ArrayList<>();
        Set<Integer> intNumbers = new HashSet<>();
        if (integers == null)
            return returnedList;

        intNumbers.addAll(integers);
        for (Integer intNumber : intNumbers) {
            int numberOfOccurrences = 0;
            for (Integer integer : integers) {
                if (intNumber.equals(integer)) {
                    numberOfOccurrences++;
                }
            }
            if (numberOfOccurrences == numberOfDuplicates) {
                returnedList.add(intNumber);
            }
        }
        return returnedList;
    }

   /* static List<Integer> findDuplicatesStream(List<Integer> integers, Integer numberOfDuplicates) {
        List<Integer> returnedList = new ArrayList<>();
        Set<Integer> intNumbers = new HashSet<>();
        if (integers == null)
            return returnedList;

        intNumbers.addAll(integers);
        for (Integer intNumber : intNumbers) {
            int numberOfOccurrences = 0;
            for (Integer integer : integers) {
                if (intNumber.equals(integer)){
                    numberOfOccurrences++;
                }
            }
            if(numberOfOccurrences == numberOfDuplicates){
                returnedList.add(intNumber);
            }
        }
        return returnedList;
        return integers.stream()
                .
    }*/
    //moveFile()
    //VAT()
}
