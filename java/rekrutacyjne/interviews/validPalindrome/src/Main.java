import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean isPalindrome(String s) {
        String str = s.replaceAll(
                "[^a-zA-Z0-9]", "");
        if(new StringBuilder(str).reverse().toString().equals(str)){
            return true;
        }
        return false;
    }
    public List<List<String>> partitionOrginal(String s) {
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
            while(occurences > 0){
                tmp += entry.getKey();
                occurences--;
            }
            inputRepeat.add(tmp);
            tmp = "";
        }
        result.add(inputRepeat);
        return result;
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> input = new ArrayList<>();
        Stack<String> inputReversed = new Stack<>();
        List<String> inputRepeat = new ArrayList<>();
        int count = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int max = 1;
        char[] charArray = s.toCharArray();
        for(char c : s.toCharArray()){
            input.add(Character.toString(c));
            count = frequencyMap.getOrDefault(c, 0) + 1;
            frequencyMap.put(c, count);
            if(count > max){
                max = count;
            }
        }
        int occurences = 0;
        result.add(input);
        String tmp = "";
        input = new ArrayList<>();
        boolean isSame = false;
        for(int i=0;i<charArray.length/2;i++){
            if (charArray[i]!=charArray[charArray.length-1-i]){
                break;
            }
            if(i==charArray.length/2-1){
                result.add(List.of(s));
                if(s.length()==max){
                    isSame=true;
                }
                max--;
            }
        }
        int rest = 0;
        while(max>1){
            tmp = "";
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                occurences = entry.getValue();
                if(occurences>max){
                    rest = occurences-max;
                    occurences=max;
                }
                while(occurences > 0){
                    tmp += entry.getKey();
                    occurences--;
                }
                input.add(tmp);
                inputReversed.add(tmp);
                tmp = "";
                if(rest > 0){
                    occurences = rest;
                    while(occurences > 0){
                        tmp += entry.getKey();
                        occurences--;
                    }
                    input.add(tmp);
                    inputReversed.add(tmp);
                    tmp = "";
                }
                rest = 0;
            }
            result.add(input);
            while(!inputReversed.isEmpty()){
                inputRepeat.add(inputReversed.pop());
            }
            if(isSame){
                result.add(inputRepeat);
            }
            input= new ArrayList<>();
            max--;
        }
        return result;
    }
    public static boolean wordBreakOld(String s, List<String> wordDict) {
        int ind = 0;
        String tmp = s;
        int attempt = 0;
        for(String w : wordDict){
            if(tmp.contains(w)){
                tmp = tmp.replace(w,".");
                if(tmp.replace(".","").isEmpty()){
                    return true;
                }
            }

            ind++;
        }
        ind--;
        while(attempt < ind){
            tmp=s;
            attempt++;
            for(int i = ind; i >= ind-attempt;i--){
                tmp = tmp.replace(wordDict.get(i),".");
                if(tmp.replace(".","").isEmpty()){
                    return true;
                }
            }
            for(int i = 0; i< ind-attempt;i++){
                // if(i==was){
                //     continue;
                // }
                tmp = tmp.replace(wordDict.get(i),".");
                if(tmp.replace(".","").isEmpty()){
                    return true;
                }
            }
            for(String w : wordDict){
                if(tmp.contains(w)){
                    tmp = tmp.replace(w,".");
                }
                if(tmp.replace(".","").isEmpty()){
                    return true;
                }
            }
        }

        return false;
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        String tmp;
        int attempt = 0;
        int l =  wordDict.size();
        while(attempt < l){
            tmp=s;
            for(int i = attempt; i< l;i++){
                tmp = tmp.replace(wordDict.get(i),".");
                if(tmp.replace(".","").isEmpty()){
                    return true;
                }
            }
            for(int i = 0; i< attempt;i++){
                tmp = tmp.replace(wordDict.get(i),".");
                if(tmp.replace(".","").isEmpty()){
                    return true;
                }
            }
            attempt++;
        }
        return false;
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf(String.valueOf(isPalindrome("A man, a plan, a canal: Panama")));
        System.out.printf(String.valueOf(partition("aab")));
        System.out.println(wordBreak("ccaccc",new ArrayList<>(List.of("cc","ac"))));
    }
}