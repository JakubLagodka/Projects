import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
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
        System.out.println(containsAorCStream(strings));

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


        System.out.println(FindStudent.findSecondTheBestStudent(null));
        System.out.println(FindStudent.findSecondTheBestStudent(Collections.emptyList()));
        System.out.println(FindStudent.findSecondTheBestStudent(Collections.singletonList(new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.5))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.6))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.6), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.6), new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.6), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.4), new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.6), new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.6), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.6), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.7))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.7), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.6))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.6), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.7))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.4), new Student("name", "surename", LocalDate.of(2001, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.7))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.4), new Student("name", "surename", LocalDate.of(2001, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.4), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.7))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.4), new Student("name", "surename", LocalDate.of(2001, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.3), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.7))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.4), new Student("name", "surename", LocalDate.of(2001, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.3), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.7))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(1999, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2001, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.7))));
        System.out.println(FindStudent.findSecondTheBestStudent(Arrays.asList(new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.4), new Student("name", "surename", LocalDate.of(2001, 2, 20), 4.4), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.7), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.7), new Student("name", "surename", LocalDate.of(2000, 2, 20), 4.5), new Student("name", "surename", LocalDate.of(2001, 2, 20), 4.5))));


        System.out.println(FindStudent.findSecondTheBestStudent(studentList));

        System.out.println(Arrays.toString(findPairs(Arrays.asList(2, 3, 4, 4, 6), 8)));

        System.out.println(findPairsList(Arrays.asList(2, 3, 4, 4, 6), 8));

        System.out.println(findPairsMap(Arrays.asList(2, 3, 4, 4, 6), 8));

        System.out.println(findPairsObject(Arrays.asList(2, 3, 4, 4, 6), 8));

        System.out.println(findDuplicates(Arrays.asList(1, 2, 4, 5, 2, 4, 5, 8, 9, 4), 2));

        System.out.println(findDuplicatesStream(Arrays.asList(1, 2, 4, 5, 2, 4, 5, 8, 9, 4), 2));

        //przerobić czy jest apply na końcu
//        List<String[]> apply = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input.txt"))
//                .map(line -> line.split(" "))
//                .filter(line -> line[0].equals("apply"))
//                .collect(Collectors.toList());
//
//        double result = Double.parseDouble(apply.get(0)[1]);
//        List<String[]> operations = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input.txt"))
//                .map(line -> line.split(" "))
//                .filter(line -> !line[0].equals("apply"))
//                .collect(Collectors.toList());
//
//        for (String[] operation : operations) {
//            result = MathematicalOperation.findOperationByName(operation[0]).calculate(result, Double.parseDouble(operation[1]));
//        }
//
//        System.out.println(result);
//
//        apply = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input2.txt"))
//                .map(line -> line.split(" "))
//                .filter(line -> line[0].equals("apply"))
//                .collect(Collectors.toList());
//
//        result = Double.parseDouble(apply.get(0)[1]);
//        operations = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input2.txt"))
//                .map(line -> line.split(" "))
//                .filter(line -> !line[0].equals("apply"))
//                .collect(Collectors.toList());
//
//        for (String[] operation : operations) {
//            result = MathematicalOperation.findOperationByName(operation[0]).calculate(result, Double.parseDouble(operation[1]));
//        }
//
//        System.out.println(result);
//
//        apply = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input3.txt"))
//                .map(line -> line.split(" "))
//                .filter(line -> line[0].equals("apply"))
//                .collect(Collectors.toList());
//
//        result = Double.parseDouble(apply.get(0)[1]);
//        operations = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input3.txt"))
//                .map(line -> line.split(" "))
//                .filter(line -> !line[0].equals("apply"))
//                .collect(Collectors.toList());
//
//        for (String[] operation : operations) {
//            result = MathematicalOperation.findOperationByName(operation[0]).calculate(result, Double.parseDouble(operation[1]));
//        }
//
//        System.out.println(result);
        List<Operation>  operations = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\input.txt"))
                .map(line -> line.split(" "))
                .map(line -> new Operation(line[0], Double.parseDouble(line[1])))
                .collect(Collectors.toList());
        Operation apply = operations.remove(operations.size() - 1);
        if ("apply".equals(apply.getName())) {

            double result = apply.getValue();

            for (Operation operation : operations) {
                result = MathematicalOperation.findOperationByName(operation.getName()).calculate(result, operation.getValue());
            }
            System.out.println(result);
        }


//obiekt nie plik
//        List<String[]> products = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\zadania\\src\\vat.txt"))
//                .map(line -> line.split(" "))
//                .collect(Collectors.toList());

//        double netto8 = 0.0;
//        double brutto8 = 0.0;
//        double netto23 = 0.0;
//        double brutto23 = 0.0;
//        double brutto0 = 0.0;
//        double tax8 = 0.0;
//        double tax23 = 0.0;
//        for (String[] product : products) {
//            if (Integer.parseInt(product[2]) == 0) {
//                brutto0 += Double.parseDouble(product[1]);
//            } else if (Integer.parseInt(product[2]) == 8) {
//                double value = Double.parseDouble(product[1]);
//                brutto8 += value;
//                double netto = value / 1.08 * 100;
//                netto = Math.round(netto);
//                netto /= 100;
//                netto8 += netto;
//                tax8 += value - netto;
//            } else if (Integer.parseInt(product[2]) == 23) {
//                double value = Double.parseDouble(product[1]);
//                brutto23 += value;
//                double netto = value / 1.23 * 100;
//                netto = Math.round(netto);
//                netto /= 100;
//                netto23 += netto;
//                tax23 += value - netto;
//            } else throw new IOException();
//        }

//        List<List<String>> products = new ArrayList<>();
//        products.add(Arrays.asList("mleko", "4.99", "8"));
//        products.add(Arrays.asList("jogurt", "1.99", "23"));
//        products.add(Arrays.asList("woda", "9.99", "0"));
//        products.add(Arrays.asList("ksiazka", "39.99", "8"));

        List<Product> products = new ArrayList<>();
        products.add(new Product("mleko", 4.99, TaxPercentage.EIGHT));
        products.add(new Product("jogurt", 1.99, TaxPercentage.TWENTY_THREE));
        products.add(new Product("woda", 9.99, TaxPercentage.NONE));
        products.add(new Product("ksiazka", 39.99, TaxPercentage.EIGHT));

        List<Tax> taxes = new ArrayList<>();

//osobna klasa i klasa dla produktów z polami
//        Tax.Calculate.calculateTax(products);
//        taxes.add(new Tax("0 procent", brutto0, brutto0, 0.0));
//        taxes.add(new Tax("8 procent", brutto8, netto8, tax8));
//        taxes.add(new Tax("23 procent", brutto23, netto23, tax23));
//        taxes.add(new Tax("suma", brutto0 + brutto8 + brutto23, brutto0 + netto8 + netto23, tax8 + tax23));
//        taxes.add(new Tax("0 procent", Tax.Calculate.getSumBrutto0(), Tax.Calculate.getSumBrutto0(), 0.0));
//        taxes.add(new Tax("8 procent", Tax.Calculate.getSumBrutto8(), Tax.Calculate.getSumNetto8(), Tax.Calculate.getSumTaxes8()));
//        taxes.add(new Tax("23 procent", Tax.Calculate.getSumBrutto23(), Tax.Calculate.getSumNetto23(), Tax.Calculate.getSumTaxes23()));
//        taxes.add(new Tax("suma", Tax.Calculate.getSumBrutto0() + Tax.Calculate.getSumBrutto8() + Tax.Calculate.getSumBrutto23(),
//                Tax.Calculate.getSumBrutto0() + Tax.Calculate.getSumNetto8() + Tax.Calculate.getSumNetto23(), Tax.Calculate.getSumTaxes8() + Tax.Calculate.getSumTaxes23()));
//
        CalculateTax calculateTax = new CalculateTax();
        calculateTax.calculate(products);

        taxes.add(new Tax("0 procent", calculateTax.getSumBrutto0(), calculateTax.getSumBrutto0(), 0.0));
        taxes.add(new Tax("8 procent", calculateTax.getSumBrutto8(), calculateTax.getSumNetto8(), calculateTax.getSumTaxes8()));
        taxes.add(new Tax("23 procent", calculateTax.getSumBrutto23(), calculateTax.getSumNetto23(), calculateTax.getSumTaxes23()));
        taxes.add(new Tax("suma", calculateTax.getSumBrutto0() + calculateTax.getSumBrutto8() + calculateTax.getSumBrutto23(),
                calculateTax.getSumBrutto0() + calculateTax.getSumNetto8() + calculateTax.getSumNetto23(), calculateTax.getSumTaxes8() + calculateTax.getSumTaxes23()));

        System.out.println(taxes);

    }

    //zrobić w strumieniu!
    static List<String> containsAorC(List<String> strings) {
        List<String> foundStrings = new ArrayList<>();

        for (String string : strings) {
            if (string.contains("a") || string.contains("c"))
                foundStrings.add(string);
        }
        return foundStrings;
    }

    static List<String> containsAorCStream(List<String> strings) {
        return strings.stream()
                .filter(str -> str.contains("a") || str.contains("c"))
                .collect(Collectors.toList());
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

        //List<Integer>[] returnedPairs = new ArrayList<Integer>[]{(ArrayList<Integer>) Arrays.asList(2, 3, 4, 4, 6)};
//stworzyć obiekt 2 elementowy, jeśli jest możliwe stworzenie obiektu, to tworzymy obiekt
        List<Integer>[] pairs = new ArrayList[2];
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

        return pairs;
    }

    static List<List<Integer>> findPairsList(List<Integer> integers, Integer sum) {
        List<List<Integer>> pairs = new ArrayList<>();

        int indexOfIntegers = 0;
        for (Integer integer : integers) {
            for (int i = indexOfIntegers + 1; i < integers.size(); i++) {
                if (integer + integers.get(i) == sum) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(integer);
                    pair.add(integers.get(i));
                    pairs.add(pair);
                }
            }
            indexOfIntegers++;
        }

        return pairs;
    }

    static List<Map<Integer, Integer>> findPairsMap(List<Integer> integers, Integer sum) {
        List<Map<Integer, Integer>> pairs = new ArrayList<>();

        int indexOfIntegers = 0;
        for (Integer integer : integers) {
            for (int i = indexOfIntegers + 1; i < integers.size(); i++) {
                if (integer + integers.get(i) == sum) {
                    Map<Integer, Integer> pair = new HashMap<>();
                    pair.put(integer, integers.get(i));
                    pairs.add(pair);
                }
            }
            indexOfIntegers++;
        }

        return pairs;
    }
//zrobić na secie
    static List<Pair> findPairsObject(List<Integer> integers, Integer sum){
        List<Pair> pairs = new ArrayList<>();
        int indexOfIntegers = 0;
        for (Integer integer : integers) {
            for (int i = indexOfIntegers + 1; i < integers.size(); i++) {
                if (integer + integers.get(i) == sum) {
                  pairs.add(new Pair(integer, integers.get(i)));
                }
            }
            indexOfIntegers++;
        }

        return pairs;
    }
    //napisać na podstawie userów po job
//    static List<Integer> findDuplicates(List<Integer> integers, Integer numberOfDuplicates) {
//        List<Integer> returnedList = new ArrayList<>();
//        Set<Integer> intNumbers = new HashSet<>();
//        if (integers == null)
//            return returnedList;
//
//        intNumbers.addAll(integers);
//        for (Integer intNumber : intNumbers) {
//            int numberOfOccurrences = 0;
//            for (Integer integer : integers) {
//                if (intNumber.equals(integer)) {
//                    numberOfOccurrences++;
//                }
//            }
//            if (numberOfOccurrences == numberOfDuplicates) {
//                returnedList.add(intNumber);
//            }
//        }
//        return returnedList;
//    }
    static List<Integer> findDuplicates(List<Integer> integers, Integer numberOfDuplicates) {

        if (integers == null)
            //return returnedList;
            return Collections.emptyList();
        Map<Integer, Integer> number = new HashMap<>();

        for (Integer integer : integers) {

            //            if (NumberInteger != null) {
//                number.put(integer, NumberInteger + 1);
//            } else {
//                number.put(integer, 1);
//            }
            number.merge(integer, 1, Integer::sum);
        }
        List<Integer> returnedList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> mapEntry : number.entrySet()) {

            if (mapEntry.getValue().equals(numberOfDuplicates)) {
                returnedList.add(mapEntry.getKey());
            }
        }
        return returnedList;
    }

    static List<Integer> findDuplicatesStream(List<Integer> integers, Integer numberOfDuplicates) {
//        List<Integer> returnedList = new ArrayList<>();
        if (integers == null)
            return Collections.emptyList();

        long l = numberOfDuplicates.longValue();
        return integers.stream()
                //.map( integer -> Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(map -> map.getValue().equals(l))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        //.filter(map -> map.getValue() == 2)

//        for (Map.Entry<Integer, Long> mapEntry : collect.entrySet()) {
//
//            if (mapEntry.getValue().equals(numberOfDuplicates.longValue())) {
//                returnedList.add(mapEntry.getKey());
//            }
//        }
//          collect.entrySet().stream()
//                .filter(map -> map.getValue() == 2)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
    }



}
