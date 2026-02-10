package org.example;

public class KaratsubaMultiplication {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int maxLength = Math.max(num1.length(), num2.length());
        num1 = padWithLeadingZeros(num1, maxLength);
        num2 = padWithLeadingZeros(num2, maxLength);

        if (maxLength == 1) {
            return String.valueOf((num1.charAt(0) - '0') * (num2.charAt(0) - '0'));
        }

        int halfLength = maxLength / 2;
        String high1 = num1.substring(0, maxLength - halfLength);
        String low1 = num1.substring(maxLength - halfLength);
        String high2 = num2.substring(0, maxLength - halfLength);
        String low2 = num2.substring(maxLength - halfLength);

        String z0 = multiply(low1, low2);
        String z1 = multiply(addStrings(low1, high1), addStrings(low2, high2));
        String z2 = multiply(high1, high2);

        String product1 = shiftLeft(z2, 2 * halfLength);
        String product2 = shiftLeft(subtractStrings(subtractStrings(z1, z2), z0), halfLength);
        String finalResult = addStrings(addStrings(product1, product2), z0);

        return finalResult.replaceFirst("^0+(?!$)", "");
    }

    private static String shiftLeft(String num, int zeros) {
        return num + "0".repeat(Math.max(0, zeros));
    }

    private static String padWithLeadingZeros(String num, int length) {
        return "0".repeat(Math.max(0, length - num.length())) + num;
    }

    private static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0, maxLength = Math.max(num1.length(), num2.length());
        num1 = padWithLeadingZeros(num1, maxLength);
        num2 = padWithLeadingZeros(num2, maxLength);

        for (int i = maxLength - 1; i >= 0; i--) {
            int sum = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    private static String subtractStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int borrow = 0, maxLength = Math.max(num1.length(), num2.length());
        num1 = padWithLeadingZeros(num1, maxLength);
        num2 = padWithLeadingZeros(num2, maxLength);

        for (int i = maxLength - 1; i >= 0; i--) {
            int diff = (num1.charAt(i) - '0') - (num2.charAt(i) - '0') - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(diff);
        }

        return result.reverse().toString().replaceFirst("^0+(?!$)", "");
    }
}