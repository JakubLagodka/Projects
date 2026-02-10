package org.example;

import java.util.HashSet;
import java.util.Set;

public class PrepSecondAttempt {

    public boolean isNumberHappy(int number) {
        Set<Integer> alreadyCalculatedNumber = new HashSet<>();
        alreadyCalculatedNumber.add(number);
        return extracted(number, alreadyCalculatedNumber);
    }

    private static boolean extracted(int number, Set<Integer> alreadyCalculatedNumber) {
        String st = String.valueOf(number);
        int sum = 0;
        for (char ch : st.toCharArray()) {
            int val = ch - '0';
            sum += val * val;
        }
        if (sum == 1) {
            return true;
        }
        if (alreadyCalculatedNumber.contains(sum)) {
            return false;
        }
        alreadyCalculatedNumber.add(sum);
        return extracted(sum, alreadyCalculatedNumber);
    }
}