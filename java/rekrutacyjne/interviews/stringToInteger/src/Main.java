//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public int myAtoi(String s) {
        int counter = 1;
        String text = s.trim();
        int result = 0;
        if(text.isEmpty()){
            return result;
        }
        boolean negative = text.charAt(0)=='-'?true:false;
        if(negative || text.charAt(0)=='+'){
            text = text.substring(1,text.length());
        }
        while(!text.isEmpty() && text.charAt(0)=='0'){
            text = text.substring(1,text.length());
        }
        if(text.isEmpty()){
            return result;
        }
        char[] chars = text.toCharArray();
        int l = chars.length;
        int[] digits = new int[l];
        int i = 0;
        int digit = 0;
        while(i < l && (int)chars[i] - 48 >= 0 && (int)chars[i] - 48 <= 9 ){
            digit = (int)chars[i] - 48;
            digits[i] = digit;
            i++;
        }
        if(i > 10 || i ==10 && digits[0] > 2){
            return negative ? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }
        while(counter <= i){
            digit = (int)Math.pow(10,i-counter)*digits[counter-1];
            if(result + digit < 0 ){
                return negative ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
            result += digit;
            counter++;
        }
        return negative ? -result: result;
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}