public class Solution {
    public String greatestLetter(String s) {
        //65 - A 97 - a
        if (s.length() == 1) {
            return "";
        }
         int ascii = 0;
        char[] chars = s.toCharArray();
        int subtract = 'a' - 'A';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 97 && s.contains(String.valueOf((char) (chars[i] + subtract)))) {
                if (ascii < chars[i]) {
                    ascii = chars[i];
                }
            }
        }
        return ascii == 0 ? "" : String.valueOf((char) (ascii));
    }
}