package org.example;

public class Main {
    public static String multiplyLargeNumbers(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        boolean isNum1Negative = num1.charAt(0) == '-';
        boolean isNum2Negative = num2.charAt(0) == '-';
        boolean isResultPositive = isNum1Negative == isNum2Negative;

        String absNum1 =  num1.replace("-", "");
        String absNum2 = num2.replace("-", "");

        int[] result = computeMultiplication(absNum1, absNum2);

        StringBuilder finalResult = new StringBuilder();
        for (int num : result) {
            if (!(finalResult.isEmpty() && num == 0)) {
                finalResult.append(num);
            }
        }

        return finalResult.isEmpty() ? "0" : !isResultPositive ? "-" + finalResult.toString() :finalResult.toString();
    }

    private static int[] computeMultiplication(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';

                int multplyResult = digit1 * digit2;

                int position1 = i + j;
                int position2 = i + j + 1;

                int sum = multplyResult + result[position2];

                result[position2] = sum % 10;

                result[position1] += sum / 10;
            }
        }
        return result;
    }

    public static String addLargeNumbers(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int additionSize = Math.max(len1, len2) + 1;
        String zeros = "";
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            zeros = String.join("", "0", zeros);
        }
        num1 = len1 < len2 ? zeros + num1 : num1;
        num2 = len2 < len1 ? zeros + num2 : num2;
        int[] result = new int[additionSize];

        for (int j = additionSize - 2; j >= 0; j--) {
            int digit2 = num2.charAt(j) - '0';
            int digit1 = num1.charAt(j) - '0';
            int addition = digit1 + digit2;

            int position1 = j;
            int position2 = j + 1;

            int sum = addition + result[position2];

            result[position2] = sum % 10;

            result[position1] += sum / 10;
        }

        StringBuilder finalResult = new StringBuilder();
        for (int num : result) {
            if (!(finalResult.isEmpty() && num == 0)) {
                finalResult.append(num);
            }
        }

        return finalResult.isEmpty() ? "0" : finalResult.toString();
    }

    public static String subtractLargeNumbers(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int additionSize = Math.max(len1, len2) + 1;
        String zeros = "";
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            zeros = String.join("", "0", zeros);
        }
        num1 = len1 < len2 ? zeros + num1 : num1;
        num2 = len2 < len1 ? zeros + num2 : num2;
        int[] result = new int[additionSize];

        for (int j = additionSize - 2; j >= 0; j--) {
            int digit2 = num2.charAt(j) - '0';
            int digit1 = num1.charAt(j) - '0';
            int addition = digit1 - digit2;

            int position1 = j;
            int position2 = j + 1;

            int sum = addition + result[position2];

            result[position2] = sum % 10;

            result[position1] += sum / 10;
        }

        StringBuilder finalResult = new StringBuilder();
        for (int num : result) {
            if (!(finalResult.isEmpty() && num == 0)) {
                finalResult.append(num);
            }
        }

        return finalResult.isEmpty() ? "0" : finalResult.toString();
    }

    public static String divideLargeNumbers(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        num1 = num1.trim();
        num2 = num2.trim();
        int len1 = num1.length();
        int len2 = num2.length();
        int i = 0;
        int rest = 0;
        int divider = 0;
        int multiplier = 1;
        for (int j = len2 - 1; j >= 0; j--) {
            int digit2 = num2.charAt(j) - '0';
            divider += digit2 * multiplier;
            multiplier *= 10;
        }
        String substringNum1 = num1.substring(0, len2);
        int divine = 0;
        multiplier = 1;
        for (int j = substringNum1.length() - 1; j >= 0; j--) {
            int digit1 = substringNum1.charAt(j) - '0';
            divine += digit1 * multiplier;
            multiplier *= 10;
        }
        if (divine < divider && substringNum1.length() < num1.length()) {
            divine = divine * 10 + num1.charAt(substringNum1.length()) - '0';
            substringNum1 += "0";
        }
        int[] result = new int[len1 - substringNum1.length() + 1];
        while (true) {
            result[i] = divine / divider;
            rest = divine % divider;
            if (len1 - substringNum1.length() == i) {
                break;
            }

            divine = rest * 10 + num1.charAt(substringNum1.length() + i) - '0';
            i++;
        }
        StringBuilder finalResult = new StringBuilder();
        for (int num : result) {
            if (!(finalResult.isEmpty() && num == 0)) {
                finalResult.append(num);
            }
        }
        if (rest > 0) {
            double fraction = (double) rest / divider;
            String decimalPart = String.valueOf(fraction).substring(1);
            finalResult.append(decimalPart);
        }

        return finalResult.isEmpty() ? "0" : finalResult.toString();
    }

    public static String multiplyLargeNumbersReversed(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String reversedNum1 = new StringBuilder(num1).reverse().toString();
        String reversedNum2 = new StringBuilder(num2).reverse().toString();

        int[] result = new int[reversedNum1.length() + reversedNum2.length()];


        for (int i = 0; i < reversedNum1.length(); i++) {
            int digit1 = reversedNum1.charAt(i) - '0';

            for (int j = 0; j < reversedNum2.length(); j++) {
                int digit2 = reversedNum2.charAt(j) - '0';

                result[i + j] += digit1 * digit2;

                if (result[i + j] >= 10) {
                    result[i + j + 1] += result[i + j] / 10;
                    result[i + j] %= 10;
                }
            }
        }

        StringBuilder finalResult = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (finalResult.isEmpty() && result[i] == 0) {

                continue;
            }
            finalResult.append(result[i]);
        }

        return finalResult.isEmpty() ? "0" : finalResult.toString();
    }

    public static String povertyLargeNumbers(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        num1 = num1.trim();
        num2 = num2.trim();
        int result = Integer.parseInt(num1);
        int exponent = 0;
        int multiplier = 1;
        for (int j = num2.length() - 1; j >= 0; j--) {
            int digit = num2.charAt(j) - '0';
            exponent += digit * multiplier;
            multiplier *= 10;
        }

        int tmp = 0;
        for (int i = 0; i < exponent - 1; i++) {
//            for (int num : result) {
//                stringResult.append(num);
//            }
            int[] comp = computeMultiplication(String.valueOf(result), num1);
            for (int i1 = 0 ; i1 < comp .length; i1++) {
                tmp += (int) (Math.pow(10,i1)*comp[comp .length -1 - i1]);
            }
            result = tmp;
            tmp = 0;
        }
        StringBuilder finalResult = new StringBuilder();

        return  String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(multiplyLargeNumbers("-19283784673", "598972674563"));
        System.out.println(multiplyLargeNumbers("-100000000000", "-100000000000000"));
        System.out.println(multiplyLargeNumbers("99", "99"));
        System.out.println(addLargeNumbers("99", "99"));
        System.out.println(addLargeNumbers("9", "9"));
        System.out.println(addLargeNumbers("9", "99"));
        System.out.println(addLargeNumbers("99", "9"));
        System.out.println(addLargeNumbers("100000000000", "100000000000000"));
        System.out.println(subtractLargeNumbers("99", "99"));
        System.out.println(subtractLargeNumbers("9", "99"));
        System.out.println(subtractLargeNumbers("99", "9"));
        System.out.println(subtractLargeNumbers("100000000000", "100000000000000"));
        System.out.println(divideLargeNumbers("9", "9"));
        System.out.println(divideLargeNumbers("99", "9"));
        System.out.println(divideLargeNumbers("548", "4"));
        System.out.println(divideLargeNumbers("2837", "9"));
        System.out.println(divideLargeNumbers("3285 ", "8"));
        System.out.println(divideLargeNumbers("270003 ", "9"));
        System.out.println(povertyLargeNumbers("2 ", "2"));
        System.out.println(povertyLargeNumbers("2 ", "3"));
        System.out.println(povertyLargeNumbers("2 ", "10"));
        System.out.println(povertyLargeNumbers("2 ", "16"));
        System.out.println(povertyLargeNumbers("2 ", "32"));
    }
}
