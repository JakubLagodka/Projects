public class Solution {
    public String reverseVowelsReplace(String s) {
        String result = s;
        String result2 = s;
        String indexes = "";
        String vovels = "aeiouAEIOU";
        for(String c : s.split("")){
            if(vovels.contains(c)){
                indexes += c;
            }
        }
        for(int i=0;i<indexes.length()/2;i++){
            result = result.replace(indexes.charAt(i),indexes.charAt(indexes.length()-1-i));
        }
        for(int i=0;i<indexes.length()/2;i++){
            result2 = result2.replace(indexes.charAt(indexes.length()-1-i),indexes.charAt(i));
        }
        return result.substring(0,indexes.length()/2) + result2.substring(indexes.length()/2);
    }
    public String reverseVowels(String s) {
        String result = "";
        int[] array = new int[300000];
        String vovels = "aeiouAEIOU";
        int index = 0;
        int arrayIndex = 0;
        for(String c : s.split("")){
            if(vovels.contains(c)){
                array[arrayIndex] = index;
                arrayIndex++;
            }
            index++;
        }
        int arrayLength = arrayIndex-1;
        if(arrayLength < 1){
            return s;
        }
        arrayIndex = 0;
        for(int i=0;i<s.length();i++){
            if(i==array[arrayIndex]){
                result += s.substring(array[arrayLength-arrayIndex],array[arrayLength-arrayIndex]+1);
                arrayIndex++;
            }else {
                result += s.charAt( i );
            }
        }
        return result;
    }
}