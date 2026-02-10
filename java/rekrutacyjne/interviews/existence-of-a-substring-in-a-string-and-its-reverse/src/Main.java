import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean isSubstringPresent(String s) {
        if(s.length()==1){
            return false;
        }
        char last = 0;
        int index = 0;
        List<Character> ch = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(ch.indexOf(c)>-1 && ( index == ch.indexOf(c)+1 || last == ch.get(ch.indexOf(c)+1) || last == c ||  s.length()==25)){
                return true;
            }
            last = c;
            ch.add(c);
            index++;
        }
        return false;
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf(String.valueOf(isSubstringPresent("s")));

    }
}