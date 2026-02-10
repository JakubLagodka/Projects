//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        char[] plate = new char[licensePlate.length()];
        int plateIdx = 0;
        for(char s: licensePlate.toCharArray()){
            if(s >= 'a' && s <= 'z' || s >= 'A' && s <= 'Z')
            {
                if(s < 'a'){
                    plate[plateIdx] = (char)(s + 'a' - 'A');
                }else{
                    plate[plateIdx] = s;
                }
                plateIdx++;
            }
        }
        int shortest = words[0].length();
        String result = "";
        int resultLength = 0;
        boolean contains = true;
        int tmp = plateIdx;
        String curWord;
        for(String word : words){
            tmp = plateIdx;
            contains = true;
            curWord = word;
            while(tmp>0){
                if(word.contains(String.valueOf(plate[tmp-1]))){
                    word = word.replaceFirst(String.valueOf(plate[tmp-1]),"");
                    tmp--;
                } else{
                    contains = false;
                    break;
                }
            }
            if(contains && tmp==0 && (resultLength==0 || curWord.length() < resultLength)){
                result = curWord;
                resultLength = curWord.length();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf(shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));

    }
}