public class Challenge {
    public static void main(String[] args) {
        System.out.println(StringChallenge("abcNdgM"));
        System.out.println(StringChallenge2("cab"));
        System.out.println(bracket("(){}[]"));
        System.out.println(bracket("([{}])"));
        System.out.println(bracket("(}"));
        System.out.println(bracket("[(])"));
        System.out.println(bracket("[({})](]"));
        System.out.println(bracket("(({}]()"));

    }
//    static boolean ArrayChallenge(String[] strArr){
//      for(int i = 0; i < strArr.length; i++){
//        //
//      }
//    }

    static String StringChallenge(String str) {
        String returned = "";

        for (int i = 0; i < str.length(); i++) {
            if ('M' == str.charAt(i)) {
                if (i > 0)
                    returned += str.charAt(i - 1);
            } else if ('N' == str.charAt(i))
                if (i < str.length() - 1)
                    returned += str.charAt(i + 1);
                else
                    returned += str.charAt(i);
        }
        return returned;
    }

    static int StringChallenge2(String str) {
        String returned = "";

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                if (i > 0)
                    returned += str.charAt(i - 1);
            } else if ("N".equals(str.charAt(i)))
                if (i < str.length() - 1)
                    returned += str.charAt(i + 1);
                else
                    returned += str.charAt(i);
        }
        return returned.length();
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
