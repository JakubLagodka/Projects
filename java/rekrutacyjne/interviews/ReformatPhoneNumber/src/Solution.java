public class Solution {
    public String reformatNumber(String number) {
        String result = number.replaceAll("\\s+","");
        result = result.replaceAll("-","") ;
        int cur = 0;
        StringBuilder builder = new StringBuilder(result);
        while(cur < builder.length()-5){
            cur += 3;
            builder.insert(cur,"-");
            cur += 1;
        }
        if(result.length()==2){
            return result;
        }
        if(cur==builder.length()-2 || cur==builder.length()-4|| cur==builder.length()-5){
            cur += 3;
            builder.insert(builder.length()-2,"-");
        }
        return builder.toString();
    }
}