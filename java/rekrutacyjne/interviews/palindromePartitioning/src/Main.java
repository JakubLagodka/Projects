import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> input = new ArrayList<>();
        List<String> inputRepeat = new ArrayList<>();
        int count = 0;
        boolean repeat = false;
        boolean same = false;
        boolean tree = false;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        char last = 0;
        for(char c : s.toCharArray()){
            input.add(Character.toString(c));
            count = frequencyMap.getOrDefault(c, 0) + 1;
            frequencyMap.put(c, count);
            if(count > 1){
                repeat = true;
            }
            if(count > 2){
                tree = true;
            }
            if(last==c){
                same = true;
            }
            last = c;
        }
        int occurences = 0;
        result.add(input);
        String tmp = "";
        if(s.length()==3 && !same){
            result.add(List.of(s));
        }
        if(!same){
            return result;
        }
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            occurences = entry.getValue();
            if(occurences==3){
                while(occurences > 1){
                    tmp += entry.getKey();
                    occurences--;
                }
                inputRepeat.add(tmp);
                tmp = String.valueOf(entry.getKey());
                inputRepeat.add(tmp);
                result.add(inputRepeat);
                inputRepeat.clear();
                occurences=3;
                tmp= "";
                while(occurences > 1){
                    tmp += entry.getKey();
                    occurences--;
                }
                inputRepeat.add(tmp);
                tmp = String.valueOf(entry.getKey());
                inputRepeat.add(tmp);
                result.add(inputRepeat);
                inputRepeat.clear();
                occurences=2;
            } if(occurences==2){
                while(occurences > 0){
                    tmp += entry.getKey();
                    occurences--;
                }
                inputRepeat.add(tmp);
                tmp = "";
            }

        }
        result.add(inputRepeat);
        return result;
    }
    public static void main(String[] args) {

        System.out.printf(partition("fff").toString());

    }
}