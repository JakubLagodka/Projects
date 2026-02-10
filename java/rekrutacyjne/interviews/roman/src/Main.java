//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public String intToRoman(int num) {
            int m = num / 1000;
            int tmp = num % 1000;
            int d =  tmp / 500;
            tmp = tmp % 500;
            int c = tmp / 100;
            tmp = tmp % 100;
            int l = tmp / 50;
            tmp = tmp % 50;
            int x = tmp / 10;
            tmp = tmp % 10;
            int v = tmp / 5;
            tmp = tmp % 5;
            String res = "";
            while(m>0){
                res += "M";
                m--;
            }
            boolean nine = false;
            while(d>0){
                if(c > 3){
                    nine = true;
                    break;
                }
                res += "D";
                d--;
            }
            while(c>0){
                if(c > 3){
                    res += nine ? "CM" : "CD";
                    break;
                }
                res += "C";
                c--;
            }
            nine = false;
            while(l>0){
                if(x > 3){
                    nine = true;
                    break;
                }
                res += "L";
                l--;
            }
            while(x>0){
                if(x > 3){
                    res += nine ? "XC": "XL";
                    break;
                }
                res += "X";
                x--;
            }
            nine = false;
            while(v>0){
                if(tmp > 3){
                    nine = true;
                    break;
                }
                res += "V";
                v--;
            }
            while(tmp>0){
                if(tmp > 3){
                    res += nine ? "IX" : "IV";
                    break;
                }
                res += "I";
                tmp--;
            }
            return res;
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