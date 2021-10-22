package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericFunctionalInterface {
    public static void main(String[] args) {
        Function<List<Integer>, Integer> functionInt = list -> {
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            return sum;
        };
        List<Integer> testList = new ArrayList<>();
        testList.add(4);
        testList.add(1);
        testList.add(3);
        System.out.println(functionInt.apply(testList));

        Function<List<Double>, Double> functionDouble = list -> {
            double sum = 0.0;
            for (Double d : list) {
                sum += d;
            }
            return sum;
        };

        List<Double> testListDouble = new ArrayList<>();
        testListDouble.add(4.5);
        testListDouble.add(1.9);
        testListDouble.add(3.3);
        System.out.println(functionDouble.apply(testListDouble));

        Function<List<? extends Number>, ? extends Number> functionGeneric = list -> {
            double sum = 0;
            for (Number number : list) {
                sum += number.doubleValue();
            }
            return sum;
        };

        List<Number> testListNumber = new ArrayList<>();
        testListNumber.add(4.5);
        testListNumber.add(1);
        testListNumber.add(-3.3);
        testListNumber.add(3000L);
        System.out.println("----------");
        System.out.println(functionGeneric.apply(testListNumber));
        System.out.println(functionGeneric.apply(testListDouble));
        System.out.println(functionGeneric.apply(testList));

        //dopisać własny interfejs funkcyjny
    }
}
