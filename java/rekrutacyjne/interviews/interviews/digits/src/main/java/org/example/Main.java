package org.example;

import java.util.*;
import java.util.stream.Collectors;

//Given a range of Numbers, Find the Numbers with No DIGIT Repeated (Both Numbers Inclusive)
public class Main {

    public static final int MAX = 100;
    static String numberString = "";
    public static void main(String[] args) {
        //1 rozwiazanie:
        for (Integer number = 0; number < MAX; number++) {
            numberString = number.toString();
            Set<String> digitSet = Arrays.stream(number.toString().split("")).collect(Collectors.toSet());
            if(digitSet.size() == numberString.length()){
                System.out.println(number);
            }
        }
        //2 rozwiazanie
        for (Integer number = 0; number < MAX; number++) {
            String numberString = number.toString();
            char[] charArray = numberString.toCharArray();
            Set<Character> digitSet =new HashSet<>();
            for (char c : charArray) {
                digitSet.add(c);
            }
            if(digitSet.size() == numberString.length()){
//                System.out.println(number);
            }
        }
        //3 rozwiązanie
        for (Integer number = 0; number < MAX; number++) {
            String numberString = number.toString();
            Set<Character> digitSet =new HashSet<>();
            for (int i = 0; i < numberString.length(); i++) {
                digitSet.add(numberString.charAt(i));
            }
            if(digitSet.size() == numberString.length()){
//                System.out.println(number);
            }
        }
        //4 rozwiązanie
        Arrays.stream(new int[]{1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14,
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28,
                29,
                30,
                31,
                32,
                33,
                34,
                35,
                36,
                37,
                38,
                39,
                40,
                41,
                42,
                43,
                44,
                45,
                46,
                47,
                48,
                49,
                50,
                51,
                52,
                53,
                54,
                55,
                56,
                57,
                58,
                59,
                60,
                61,
                62,
                63,
                64,
                65,
                66,
                67,
                68,
                69,
                70,
                71,
                72,
                73,
                74,
                75,
                76,
                77,
                78,
                79,
                80,
                81,
                82,
                83,
                84,
                85,
                86,
                87,
                88,
                89,
                90,
                91,
                92,
                93,
                94,
                95,
                96,
                97,
                98,
                99,
                100,
                101,
                102
        }).forEach(value -> {
           String stringValue = String.valueOf(value);
            Set<String> set = Arrays.stream(stringValue.split("")).collect(Collectors.toSet());
            if (set.size()==stringValue.length()){
                System.out.println(value);
            }
        });
    }
}