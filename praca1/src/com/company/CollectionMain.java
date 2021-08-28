package com.company;

import java.util.LinkedList;
import java.util.List;

public class CollectionMain {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(-1);
        linkedList.add(0);
        Integer integer = minNumber(linkedList);
        System.out.println(integer);

        List<Integer> integers = evenNumber(linkedList);

        System.out.println(integers);

        List<String> strings = new LinkedList<>();
        strings.add("sa");
        strings.add("kuba");
        strings.add("ahgdihgal");
        List<Integer> evenStringLength = evenStringLength(strings);

        System.out.println(evenStringLength);
    }

    static Integer minNumber(List<Integer> list) {
        Integer min = list.get(0);

        for (Integer integer : list) {
            if (integer < min)
                min = integer;
        }
        return min;
    }

    static List<Integer> evenNumber(List<Integer> list) {
        List<Integer> result = new LinkedList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                result.add(integer);
            }
        }
        return result;
    }

    static List<Integer> evenStringLength(List<String> strings) {
        List<Integer> result = new LinkedList<>();

        for (String string : strings) {
            if (string.length() % 2 == 0) {
                result.add(string.length());
            }
        }
        return result;
    }
}
