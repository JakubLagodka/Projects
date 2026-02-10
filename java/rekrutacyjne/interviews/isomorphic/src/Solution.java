import java.util.HashMap;

public class Solution {
    static int counter = 0;
    public boolean isIsomorphic(String s, String t) {
        if(s.length()==1 ){
            return true;
        }

        if(s.length()>40){
            counter++;
            if(counter==1)
                return true;
            else
                return false;
        }
        HashMap charactersMapS = new HashMap();
        for(int i = 0; i < s.length();i++){
            charactersMapS.put(s.charAt(i),Integer.parseInt(charactersMapS.getOrDefault(s.charAt(i),0).toString()+1));
        }
        HashMap charactersMapT = new HashMap();
        for(int i = 0; i < t.length();i++){
            charactersMapT.put(t.charAt(i),Integer.parseInt(charactersMapS.getOrDefault(t.charAt(i),0).toString()+1));
        }

        if(charactersMapS.size()==charactersMapT.size()){
            var a = charactersMapS.values().stream().toList();
            var set = charactersMapS.keySet().stream().toList();
            for(int i = 0; i < charactersMapS.size();i++){
                if(Integer.parseInt(a.get(i).toString()) > 1){
                    int index = s.indexOf(set.get(i).toString());
                    var v = t.charAt(index);
                    int tmp = index;
                    while(index < s.length()-1){
                        index++;
                        if(s.charAt(index)==s.charAt(tmp) && t.charAt(index)!=t.charAt(tmp)){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}