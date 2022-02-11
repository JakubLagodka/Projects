public class Challenge {
    public static void main(String[] args) {
        System.out.println(StringChallenge("abcNdgM"));
    }
//    static boolean ArrayChallenge(String[] strArr){
//      for(int i = 0; i < strArr.length; i++){
//        //
//      }
//    }

    static String StringChallenge(String str) {
        String returned = "";

        for (int i = 0; i < str.length(); i++) {
            if ( 'M' == str.charAt(i)) {
                if (i > 0)
                    returned += str.charAt(i - 1);
            } else if ('N' == str.charAt(i))
                if (i < str.length() - 1)
                    returned += str.charAt(i+1);
                else
                    returned += str.charAt(i);
        }
        return returned;
    }

    static String StringChallenge2(String str) {
        String returned = "";

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i-1)) {
                if (i > 0)
                    returned += str.charAt(i - 1);
            } else if ("N".equals(str.charAt(i)))
                if (i < str.length() - 1)
                    returned += str.charAt(i+1);
                else
                    returned += str.charAt(i);
        }
        return returned;
    }
}
