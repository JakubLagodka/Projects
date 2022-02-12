public class Challenge {
    public static void main(String[] args) {
        System.out.println(arrayChallenge(new String[]{"1", "2", "2", "3", "#", "#", "3"}));
        System.out.println(arrayChallenge(new String[]{"1"}));
        System.out.println(arrayChallenge(new String[]{"1", "2"}));
        System.out.println(arrayChallenge(new String[]{"1", "2", "2"}));
        System.out.println(arrayChallenge(new String[]{"1", "2", "3"}));
        System.out.println(arrayChallenge(new String[]{"1", "2", "2", "3", "3"}));
        System.out.println(arrayChallenge(new String[]{"1", "2", "2", "3", "3","3","3","4","4","4","4","4","4","4","4"}));
        System.out.println(arrayChallenge(new String[]{"1", "2", "2", "3", "3","3","3","4","4","4","4","4","4","4","5"}));
        System.out.println();
        System.out.println(stringChallenge("abcNdgM"));
        System.out.println(stringChallenge("MMba"));
        System.out.println(stringChallenge("Mba"));
        System.out.println(stringChallenge("Nba"));
        System.out.println(stringChallenge("abcN"));
        System.out.println(stringChallenge("abcNN"));
        System.out.println(stringChallenge("abcM"));
        System.out.println(stringChallenge("abcMM"));
        System.out.println();
        System.out.println(stringChallenge2("cab"));
        System.out.println(stringChallenge2("bcab"));
        System.out.println(stringChallenge2("a"));
        System.out.println(stringChallenge2("aaa"));
        System.out.println(stringChallenge2("cabb"));
        //System.out.println(stringChallenge2("caaa"));
        System.out.println(stringChallenge2("aaab"));
        System.out.println();
        System.out.println(bracket("(){}[]"));
        System.out.println(bracket("([{}])"));
        System.out.println(bracket("(}"));
        System.out.println(bracket("[(])"));
        System.out.println(bracket("[({})](]"));
        System.out.println(bracket("(({}]()"));
        System.out.println(bracket("(({"));
        System.out.println(bracket(")}]"));
        System.out.println(bracket(""));

    }
//zrobić w pętli
    static boolean arrayChallenge(String[] strArr) {
        if (strArr.length >= 3) {
            if (!strArr[1].equals(strArr[2]))
                return false;
            if (strArr.length > 3 && strArr.length < 7)
                return false;
            if (strArr.length >= 7) {
                if (!strArr[3].equals(strArr[6]) || !strArr[4].equals(strArr[5]))
                    return false;
            }
        } else if (strArr.length == 2)
            return false;

        return true;
    }
//poprawić dla Mba
    static String stringChallenge(String str) {
        String returned = "";
       // returned += str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if ('M' == str.charAt(i))
                returned += str.charAt(i - 1);
            else if ('N' != str.charAt(i) && 'N' != str.charAt(i - 1))
                returned += str.charAt(i);
        }
        return returned;
    }
//poprawić
    static int stringChallenge2(String str) {
        String returned = "";
        String returned2 = "";
        boolean isReduced = false;
        boolean isReturned2 = false;
        boolean isDifferent = false;
        for (int i = 1; i < str.length(); i++) {
            if (!isDifferent && str.charAt(i) != str.charAt(i - 1)) {
                if (('a' == str.charAt(i) || 'a' == str.charAt(i - 1)) && ('b' == str.charAt(i) || 'b' == str.charAt(i - 1)))
                    returned += 'c';
                if (('a' == str.charAt(i) || 'a' == str.charAt(i - 1)) && ('c' == str.charAt(i) || 'c' == str.charAt(i - 1)))
                    returned += 'b';
                if (('b' == str.charAt(i) || 'b' == str.charAt(i - 1)) && ('c' == str.charAt(i) || 'c' == str.charAt(i - 1)))
                    returned += 'a';
                isDifferent = true;
            } else if (isDifferent && returned.charAt(returned.length() - 1) != str.charAt(i)) {
                if (('a' == str.charAt(i) || 'a' == returned.charAt(returned.length() - 1)) && ('b' == str.charAt(i) || 'b' == returned.charAt(returned.length() - 1))) {
                    returned2 += returned.charAt(returned.length() - 2);
                    returned2 += 'c';
                }

                if (('a' == str.charAt(i) || 'a' == returned.charAt(returned.length() - 1)) && ('c' == str.charAt(i) || 'c' == returned.charAt(returned.length() - 1))) {
                    returned2 += returned.charAt(returned.length() - 2);
                    returned2 += 'b';
                }

                if (('b' == str.charAt(i) || 'b' == returned.charAt(returned.length() - 1)) && ('c' == str.charAt(i) || 'c' == returned.charAt(returned.length() - 1))) {
                    returned2 += returned.charAt(returned.length() - 2);
                    returned2 += 'a';
                }

                isReturned2 = true;
            } else returned += str.charAt(i);
        }
        for (int i = 1; i < returned2.length(); i++) {
            returned = "";
            if (returned2.charAt(i) != returned2.charAt(i - 1)) {
                if (('a' == returned2.charAt(i) || 'a' == returned2.charAt(i - 1)) && ('b' == returned2.charAt(i) || 'b' == returned2.charAt(i - 1)))
                    returned += 'c';
                if (('a' == returned2.charAt(i) || 'a' == returned2.charAt(i - 1)) && ('c' == returned2.charAt(i) || 'c' == returned2.charAt(i - 1)))
                    returned += 'b';
                if (('b' == returned2.charAt(i) || 'b' == returned2.charAt(i - 1)) && ('c' == returned2.charAt(i) || 'c' == returned2.charAt(i - 1)))
                    returned += 'a';
                isReturned2 = false;
            } else returned += str.charAt(i);
        }
//        while (!isReduced) {
//            isDifferent = false;
//            for (int i = 1; i < returned.length(); i++) {
//                if (!isDifferent && returned.charAt(i) != returned.charAt(i - 1)) {
//                    if (('a' == returned.charAt(i) || 'a' == returned.charAt(i - 1)) && ('b' == returned.charAt(i) || 'b' == returned.charAt(i - 1)))
//                        returned2 += 'c';
//                    if (('a' == returned.charAt(i) || 'a' == returned.charAt(i - 1)) && ('c' == returned.charAt(i) || 'c' == returned.charAt(i - 1)))
//                        returned2 += 'b';
//                    if (('b' == returned.charAt(i) || 'b' == returned.charAt(i - 1)) && ('c' == returned.charAt(i) || 'c' == returned.charAt(i - 1)))
//                        returned2 += 'a';
//                    isDifferent = true;
//
//                } else if (isDifferent && returned2.charAt(returned2.length() - 1) != returned.charAt(i)) {
//                    if (('a' == returned.charAt(i) || 'a' == returned2.charAt(returned2.length() - 1)) && ('b' == returned.charAt(i) || 'b' == returned2.charAt(returned2.length() - 1)))
//                        returned2 += 'c';
//                    if (('a' == returned.charAt(i) || 'a' == returned2.charAt(returned2.length() - 1)) && ('c' == returned.charAt(i) || 'c' == returned2.charAt(returned2.length() - 1)))
//                        returned2 += 'b';
//                    if (('b' == returned.charAt(i) || 'b' == returned2.charAt(returned2.length() - 1)) && ('c' == returned.charAt(i) || 'c' == returned2.charAt(returned2.length() - 1)))
//                        returned2 += 'a';
//                } else returned2 += returned.charAt(i);
//            }
//            if (!isDifferent)
//                isReduced = true;
//        }
        if (!isReturned2)
            return returned.length();
        else
            return returned2.length();
    }

    static boolean bracket(String str) {
        int number1 = 0;
        int number2 = 0;
        int number3 = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '{')
                number1++;
            if (str.charAt(i) == '[')
                number2++;
            if (str.charAt(i) == '(')
                number3++;
            if (str.charAt(i) == '}') {
                if (i == 0 || number1 == 0)
                    return false;
                if (str.charAt(i - 1) != '{')
                    if (str.charAt(i - 1) != ')' && str.charAt(i - 1) != ']')
                        return false;
                number1--;
            }
            if (str.charAt(i) == ']') {
                if (i == 0 || number2 == 0)
                    return false;
                if (str.charAt(i - 1) != '[')
                    if (str.charAt(i - 1) != ')' && str.charAt(i - 1) != '}')
                        return false;
                number2--;
            }
            if (str.charAt(i) == ')') {
                if (i == 0 || number3 == 0)
                    return false;
                if (str.charAt(i - 1) != '(')
                    if (str.charAt(i - 1) != ']' && str.charAt(i - 1) != ']')
                        return false;

                number3--;
            }
        }
        if (number1 > 0 || number2 > 0 || number3 > 0)
            return false;
        return true;
    }
}
